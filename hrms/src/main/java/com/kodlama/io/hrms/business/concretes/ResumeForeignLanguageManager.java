package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import com.kodlama.io.hrms.business.abstracts.ResumeForeignLanguageService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.ResumeForeignLanguageDao;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.concretes.ResumeForeignLanguage;
import com.kodlama.io.hrms.entities.dtos.ForeignLanguageForAddDto;

@Service
public class ResumeForeignLanguageManager implements ResumeForeignLanguageService {

	private ResumeForeignLanguageDao resumeForeignLanguageDao;
	private ForeignLanguageService foreignLanguageService;
	@Autowired
	public ResumeForeignLanguageManager(ResumeForeignLanguageDao resumeForeignLanguageDao, ForeignLanguageService foreignLanguageService) {
		super();
		this.resumeForeignLanguageDao = resumeForeignLanguageDao;
		this.foreignLanguageService=foreignLanguageService;
	}

	@Override
	public Result addRange(List<ForeignLanguageForAddDto> foreignLanguages , Resume resume) {

		for(ForeignLanguageForAddDto foreignLanguage : foreignLanguages) {
			Result businessRulesResult=BusinessRules.run(
					checkIfLanguageExistsInDatabase(foreignLanguage.getForeignLanguage().getId())
					);

			if(businessRulesResult != null) {
				return businessRulesResult;
			}
			ResumeForeignLanguage resumeForeignLanguage = new ResumeForeignLanguage(resume,foreignLanguage.getForeignLanguage(),foreignLanguage.getRatio());

			resumeForeignLanguageDao.save(resumeForeignLanguage);
		}
		return new SuccessResult();
	}
	
	private Result checkIfLanguageExistsInDatabase(int id) {
		if ( foreignLanguageService.findById(id) == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

}
