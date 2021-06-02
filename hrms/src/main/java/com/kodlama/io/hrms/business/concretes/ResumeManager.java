package com.kodlama.io.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import com.kodlama.io.hrms.business.abstracts.JobExperienceService;
import com.kodlama.io.hrms.business.abstracts.ResumeService;
import com.kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.io.hrms.business.abstracts.SkillService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.ResumeDao;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ResumeWithDetailsDto;



@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private SchoolDepartmentService schoolDepartmentService;
	private JobExperienceService jobExperienceService;
	private ForeignLanguageService foreignLanguageService;
	private SkillService skillService;
	

	@Autowired
	public ResumeManager(ResumeDao resumeDao, 
			SchoolDepartmentService schoolDepartmentService,
			JobExperienceService jobExperienceService,
			ForeignLanguageService foreignLanguageService,
			SkillService skillService) {
		super();
		this.resumeDao = resumeDao;
		this.schoolDepartmentService = schoolDepartmentService;
		this.jobExperienceService = jobExperienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.skillService = skillService;
	}


	@Override
	public DataResult<ResumeWithDetailsDto> getResumeWithDetails(int id) {
		ResumeWithDetailsDto resume = resumeDao.getResumeWithDetailsByEmployee_UserId(id);
		if(resume==null) return new ErrorDataResult<ResumeWithDetailsDto>();
		resume.setSchoolDepartments(schoolDepartmentService.findByEmployeeSchoolDepartments_Employee_UserId(id).getData());
		resume.setJobExperiences(jobExperienceService.findByResume_Id(resume.getId()).getData());
		resume.setForeignLanguages(foreignLanguageService.findByResume_Id(id).getData());
		resume.setSkills(skillService.findByResume_Id(resume.getId()).getData());
		return new SuccessDataResult<ResumeWithDetailsDto>(resume);
	}


	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
	}

}
