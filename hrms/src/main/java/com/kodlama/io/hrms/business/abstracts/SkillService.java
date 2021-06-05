package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.concretes.Skill;
import com.kodlama.io.hrms.entities.dtos.SkillDetailsDto;

public interface SkillService {

	DataResult<List<SkillDetailsDto>> findByResume_Id(int id);
	DataResult<Skill> findById(int id);
}
