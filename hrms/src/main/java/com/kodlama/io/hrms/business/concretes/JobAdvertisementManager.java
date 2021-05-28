package com.kodlama.io.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.CityService;
import com.kodlama.io.hrms.business.abstracts.EmployerService;
import com.kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import com.kodlama.io.hrms.business.abstracts.JobPositionService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.io.hrms.entities.concretes.dtos.JobAdvertisementForAddDto;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private CityService cityService;


	

    @Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerService employerService,
			JobPositionService jobPositionService, CityService cityService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
	}



	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrue());
	}



	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueOrderByCreateDate());
	}



	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_EmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueAndEmployer_UserId(employerId));
	}



	@Override
	public Result addNew(JobAdvertisementForAddDto jobAdvertisement) {
		Result businessRulesResult = BusinessRules.run( 
				isJobPositionValid(jobAdvertisement.getJobPositionId()),
				isJobDescValid(jobAdvertisement.getJobDescription()),
				isCityValid(jobAdvertisement.getCityId()),
				isOpenPositionValid(jobAdvertisement.getOpenPositionCount()),
				isEndDateValid(jobAdvertisement.getLastApplyDate())
				);
		if ( businessRulesResult != null ) return businessRulesResult;
		
		// Aslında burası authenticationdan gelecek fakat şu an öğrenmedik, o yüzden el ile istiyoruz :)
		if(!employerService.getById(jobAdvertisement.getEmployerId()).isSuccess()) {
			return new ErrorResult("Böyle bir iş veren firma yok.");
		}
		
		
		//Automapper entegrasyonu ile çok daha clean hale getirilebilir.
		JobAdvertisement jobAdvertisementToAdd = new JobAdvertisement(jobAdvertisement.getJobDescription(), 
				jobAdvertisement.getMinSalary(), 
				jobAdvertisement.getMaxSalary(), 
				jobAdvertisement.getOpenPositionCount(), 
				jobAdvertisement.getLastApplyDate(), 
				new Date(), 
				jobAdvertisement.isActive());
		jobAdvertisementToAdd.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
		jobAdvertisementToAdd.setJobPosition(jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
		jobAdvertisementToAdd.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());
		jobAdvertisementDao.save(jobAdvertisementToAdd);
		
		return new SuccessResult("İş ilanı başarı ile oluşturuldu.");
	}
	

	@Override
	public Result changeStatus(int advertisementId, int employerId) {
		JobAdvertisement jobAdvertisementToUpdate = jobAdvertisementDao.findByIdAndEmployer_UserId(advertisementId, employerId);
		if(jobAdvertisementToUpdate==null) return new ErrorResult("Bu kriterlere uyan bir iş ilanı bulamadı. Böyle bir iş ilanı yok veya bu iş ilanı bu şirkete ait değil");
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessResult("Belirtilen iş ilanı " + (jobAdvertisementToUpdate.isActive() ? "aktif" : "pasif") + " hale getirildi.");
	}
	
	private Result isJobPositionValid(int id) {
		if(id<=0) return new ErrorResult("İş pozisyonu doğru girilmedi.");
		if(jobPositionService.getById(id).getData() == null) return new ErrorResult("Böyle bir iş pozisyonu yok.");
		return new SuccessResult();
	}
	private Result isJobDescValid(String jobDesc) {
		if(jobDesc == null || jobDesc.equals("")) return new ErrorResult("İş açıklaması doğru girilmedi");
		return new SuccessResult();
	}
	private Result isCityValid(int id) {
		if(id<=0) return new ErrorResult("Şehir doğru girilmedi");
		if(cityService.getById(id).getData() == null) return new ErrorResult("Böyle bir şehir yok.");
		return new SuccessResult();
	}
	private Result isOpenPositionValid(int count) {
		if(count<=0) return new ErrorResult("Açık iş pozisyonu 0 ve 0'dan küçük olamaz.");
		return new SuccessResult();
	}
	private Result isEndDateValid(Date endDate) {

		if(new Date().compareTo(endDate) > 0) {
			return new ErrorResult("Son başvuru tarihi iş ilanı tarihinden önce olamaz.");
		}
		return new SuccessResult();
	}




}
