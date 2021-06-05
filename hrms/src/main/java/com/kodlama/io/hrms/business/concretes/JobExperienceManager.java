package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.JobExperienceService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import com.kodlama.io.hrms.entities.concretes.JobExperience;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.JobExperienceForAddDto;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}


	@Override
	public DataResult<List<JobExperience>> findByResume_Id(int id) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findByResume_IdOrderByEndDateDesc(id));
	}


	@Override
	public Result add(JobExperienceForAddDto jobExperience,Resume resume) {
		JobExperience jobExperienceToAdd = new JobExperience(jobExperience.getOfficeName(),
				jobExperience.getPosition(), 
				jobExperience.getStartDate(),
				jobExperience.getEndDate(),
				resume);
		jobExperienceDao.save(jobExperienceToAdd);
		return new SuccessResult();
	}


	@Override
	public Result addRange(List<JobExperienceForAddDto> jobExperiences, Resume resume) {
		for(JobExperienceForAddDto jobExperience : jobExperiences) {
			JobExperience jobExperienceToAdd = new JobExperience(jobExperience.getOfficeName(),
					jobExperience.getPosition(), 
					jobExperience.getStartDate(),
					jobExperience.getEndDate(),
					resume);
			jobExperienceDao.save(jobExperienceToAdd);	
		}
		return new SuccessResult();
	}

}
