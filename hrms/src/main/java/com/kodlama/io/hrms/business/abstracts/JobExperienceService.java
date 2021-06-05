package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.JobExperience;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.JobExperienceForAddDto;

public interface JobExperienceService {
		DataResult<List<JobExperience>> findByResume_Id(int id);
		Result add(JobExperienceForAddDto jobExperience,Resume resume);
		Result addRange(List<JobExperienceForAddDto> jobExperiences, Resume resume);
}
