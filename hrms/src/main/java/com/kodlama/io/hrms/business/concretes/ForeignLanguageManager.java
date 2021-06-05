package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.kodlama.io.hrms.entities.concretes.ForeignLanguage;
import com.kodlama.io.hrms.entities.dtos.ForeignLanguageDetailsDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}


	@Override
	public DataResult<List<ForeignLanguageDetailsDto>> findByResume_Id(int id) {
		return new SuccessDataResult<List<ForeignLanguageDetailsDto>>(foreignLanguageDao.findByResume_ResumeId(id));
	}


	@Override
	public DataResult<ForeignLanguage> findById(int id) {
		return new SuccessDataResult<ForeignLanguage>( foreignLanguageDao.getOne( id ));
	}

}
