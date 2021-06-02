package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
		DataResult<List<JobExperience>> findByResume_Id(int id);
}
