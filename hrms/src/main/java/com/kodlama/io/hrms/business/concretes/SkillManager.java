package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.SkillService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.SkillDao;
import com.kodlama.io.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> findByResume_Id(int id) {
		return new SuccessDataResult<List<Skill>>(skillDao.findByResume_Id(id));
	}

}
