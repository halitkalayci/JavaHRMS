package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.ResumeSkillService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.results.ErrorResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.ResumeSkillDao;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.concretes.ResumeSkill;
import com.kodlama.io.hrms.entities.dtos.SkillForAddDto;

@Service
public class ResumeSkillManager implements ResumeSkillService{

	@Autowired
	ResumeSkillDao resumeSkillDao;
	
	@Override
	public Result addRange(List<SkillForAddDto> skills, Resume resume) {
		for(SkillForAddDto skill : skills) {
			Result businessRules = BusinessRules.run(checkIfSkillExistsInDatabase(skill.getSkill().getId()));
			if(businessRules != null) return businessRules;
			
			ResumeSkill resumeSkill = new ResumeSkill(resume,skill.getSkill(), skill.getLevel());
			System.out.println(resumeSkill.getSkill());
			resumeSkillDao.save(resumeSkill);
		}
		return new SuccessResult();
	}
	
	private Result checkIfSkillExistsInDatabase(int skillId) {
		if(resumeSkillDao.findById(skillId) == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

}
