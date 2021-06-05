package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.SkillService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.SkillDao;
import com.kodlama.io.hrms.entities.concretes.Skill;
import com.kodlama.io.hrms.entities.dtos.SkillDetailsDto;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<SkillDetailsDto>> findByResume_Id(int id) {
		return new SuccessDataResult<List<SkillDetailsDto>>(skillDao.findByResume_ResumeId(id));
	}

	@Override
	public DataResult<Skill> findById(int id) {
		Skill skill = skillDao.getOne(id);
		if(skill==null) return new ErrorDataResult<Skill>();
		return new SuccessDataResult<Skill>(skill);
	}

}
