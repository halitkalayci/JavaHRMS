package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.EmployeeJobAdvertisementFavoriteService;
import com.kodlama.io.hrms.business.abstracts.EmployeeService;
import com.kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.EmployeeJobAdvertisementFavoriteDao;
import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.EmployeeJobAdvertisementFavorite;
import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.io.hrms.entities.dtos.JobAdvertisementFavoriteToToggleDto;
@Service
public class EmployeeJobAdvertisementFavoriteManager implements EmployeeJobAdvertisementFavoriteService {

	private EmployeeJobAdvertisementFavoriteDao employeeJobAdvertisementFavoriteDao;
	private EmployeeService employeeService;
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public EmployeeJobAdvertisementFavoriteManager(
			EmployeeJobAdvertisementFavoriteDao employeeJobAdvertisementFavoriteDao, EmployeeService employeeService,
			JobAdvertisementService jobAdvertisementService) {
		super();
		this.employeeJobAdvertisementFavoriteDao = employeeJobAdvertisementFavoriteDao;
		this.employeeService = employeeService;
		this.jobAdvertisementService = jobAdvertisementService;
	}



	@Override
	public DataResult<List<EmployeeJobAdvertisementFavorite>> getByEmployeeId(int id) {
		
		return new SuccessDataResult<List<EmployeeJobAdvertisementFavorite>>(this.employeeJobAdvertisementFavoriteDao.getByEmployee_UserId(id));
	}



	@Override
	public Result addNew(JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto) {
		Result businessRulesResult = BusinessRules.run(
				isEmployeeNull(jobAdvertisementAddToFavoriteDto.getEmployeeId()),
				isJobAdvertisementNull(jobAdvertisementAddToFavoriteDto.getJobAdvertisementId())
				);
		if(businessRulesResult != null) return businessRulesResult;
		
		EmployeeJobAdvertisementFavorite employeeJobAdvertisementFavorite = new EmployeeJobAdvertisementFavorite();
		
		Employee employee = employeeService.getById(jobAdvertisementAddToFavoriteDto.getEmployeeId()).getData();
		JobAdvertisement jobAdvertisement = jobAdvertisementService.findById(jobAdvertisementAddToFavoriteDto.getJobAdvertisementId()).getData();
		
		employeeJobAdvertisementFavorite.setEmployee(employee);
		employeeJobAdvertisementFavorite.setJobAdvertisement(jobAdvertisement);
		employeeJobAdvertisementFavoriteDao.save(employeeJobAdvertisementFavorite);
		
		return new SuccessResult("İlan başarıyla favorilere eklendi.");
	}
	

	@Override
	public Result remove(JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto) {
		Result businessRulesResult = BusinessRules.run(
				isEmployeeNull(jobAdvertisementAddToFavoriteDto.getEmployeeId()),
				isJobAdvertisementNull(jobAdvertisementAddToFavoriteDto.getJobAdvertisementId())
				);
		if(businessRulesResult != null) return businessRulesResult;
		
		
		
		Employee employee = employeeService.getById(jobAdvertisementAddToFavoriteDto.getEmployeeId()).getData();
		JobAdvertisement jobAdvertisement = jobAdvertisementService.findById(jobAdvertisementAddToFavoriteDto.getJobAdvertisementId()).getData();
		
		EmployeeJobAdvertisementFavorite employeeJobAdvertisementFavorite = employeeJobAdvertisementFavoriteDao.getByEmployee_UserIdAndJobAdvertisementId(employee.getUserId(), jobAdvertisement.getId());
		if(employeeJobAdvertisementFavorite != null)
			employeeJobAdvertisementFavoriteDao.delete(employeeJobAdvertisementFavorite);
		
		return new SuccessResult("İlan başarıyla favorilerden kaldırıldı.");
	}

	
	private Result isEmployeeNull(int employeeId) {
		Employee employee = employeeService.getById(employeeId).getData();
		if(employee == null) return new ErrorResult("Böyle bir iş arayan bulunamadı");
		return new SuccessResult();
	}
	private Result isJobAdvertisementNull(int jobAdId) {
		JobAdvertisement jobAdvertisement = jobAdvertisementService.findById(jobAdId).getData();
		if(jobAdvertisement == null) return new ErrorResult("Böyle bir iş ilanı bulunamadı");
		return new SuccessResult();
	}



}
