package com.kodlama.io.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kodlama.io.hrms.business.abstracts.EmployerService;
import com.kodlama.io.hrms.business.abstracts.EmployerUpdateRequestService;
import com.kodlama.io.hrms.core.utilities.files.FileService;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.EmployerUpdateRequestDao;
import com.kodlama.io.hrms.entities.concretes.Employer;
import com.kodlama.io.hrms.entities.concretes.EmployerUpdateRequest;
import com.kodlama.io.hrms.entities.dtos.EmployerUpdateRequestForAddDto;

@Service
public class EmployerUpdateRequestManager implements EmployerUpdateRequestService{

	private EmployerUpdateRequestDao employerUpdateRequestDao;
	private EmployerService employerService;
	private FileService fileService;
	@Autowired
	public EmployerUpdateRequestManager(EmployerUpdateRequestDao employerUpdateRequestDao, FileService fileService,EmployerService employerService) {
		super();
		this.employerUpdateRequestDao = employerUpdateRequestDao;
		this.fileService = fileService;
		this.employerService = employerService;
	}

	@Override
	public Result canSubmitNewUpdateRequest(int id) {
		EmployerUpdateRequest employerUpdateRequest = employerUpdateRequestDao.getByEmployer_UserIdAndIsApprovedIsNull(id);
		if(employerUpdateRequest != null) return new ErrorResult("Halihazırda onaylanmayı bekleyen bir güncelleme isteğiniz bulunuyor.");
		return new SuccessResult();
	}

	@Override
	public Result addNew(EmployerUpdateRequestForAddDto employerUpdateRequestForAddDto,MultipartFile avatar) {
		Employer employer = employerService.getById(employerUpdateRequestForAddDto.getEmployerId()).getData();
		EmployerUpdateRequest employerUpdateRequest = new EmployerUpdateRequest(
				employer,
				employerUpdateRequestForAddDto.getUpdatedCompanyName(),
				employerUpdateRequestForAddDto.getUpdatedCompanyPhone(),
				employerUpdateRequestForAddDto.getUpdatedCompanyWebsite(),
				employerUpdateRequestForAddDto.getUpdatedCompanyEmail(),
				LocalDate.now());
		
		if(avatar != null) {
			String path = fileService.upload(avatar);
			employerUpdateRequest.setUpdatedAvatarPath(path);
		}
			
		employerUpdateRequestDao.save(employerUpdateRequest);
		return new SuccessResult("Güncelleme isteğiniz başarıyla alındı.");
	}
	

}

