package com.kodlama.io.hrms.business.concretes;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.EmployeeService;
import com.kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import com.kodlama.io.hrms.business.abstracts.JobExperienceService;
import com.kodlama.io.hrms.business.abstracts.ResumeForeignLanguageService;
import com.kodlama.io.hrms.business.abstracts.ResumeService;
import com.kodlama.io.hrms.business.abstracts.ResumeSkillService;
import com.kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.io.hrms.business.abstracts.SkillService;
import com.kodlama.io.hrms.core.utilities.business.BusinessRules;
import com.kodlama.io.hrms.core.utilities.files.FileService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;

import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.ResumeDao;
import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ResumeForAddDto;
import com.kodlama.io.hrms.entities.dtos.ResumeWithDetailsDto;



@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private SchoolDepartmentService schoolDepartmentService;
	private JobExperienceService jobExperienceService;
	private ForeignLanguageService foreignLanguageService;
	private SkillService skillService;
	private ResumeForeignLanguageService resumeForeignLanguageService;
	private EmployeeService employeeService;
	private ResumeSkillService resumeSkillService;
	private FileService fileService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, 
			SchoolDepartmentService schoolDepartmentService,
			JobExperienceService jobExperienceService,
			ForeignLanguageService foreignLanguageService,
			ResumeForeignLanguageService resumeForeignLanguageService,
			SkillService skillService,
			ResumeSkillService resumeSkillService,
			EmployeeService employeeService,
			FileService fileService) {
		super();
		this.resumeDao = resumeDao;
		this.schoolDepartmentService = schoolDepartmentService;
		this.jobExperienceService = jobExperienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.skillService = skillService;
		this.resumeForeignLanguageService=resumeForeignLanguageService;
		this.employeeService = employeeService;
		this.resumeSkillService = resumeSkillService;
		this.fileService = fileService;
	}


	@Override
	public DataResult<ResumeWithDetailsDto> getResumeWithDetails(int id) {
		ResumeWithDetailsDto resume = resumeDao.getResumeWithDetailsById(id);
		
		if(resume==null) return new ErrorDataResult<ResumeWithDetailsDto>();
		
		resume.setSchoolDepartments(schoolDepartmentService.findByEmployeeSchoolDepartments_Employee_UserId(resume.getEmployee().getUserId()).getData());
		
		resume.setJobExperiences(jobExperienceService.findByResume_Id(resume.getId()).getData());
		
		resume.setForeignLanguages(foreignLanguageService.findByResume_Id(id).getData());
		
		resume.setSkills(skillService.findByResume_Id(resume.getId()).getData());
		
		return new SuccessDataResult<ResumeWithDetailsDto>(resume);
	}


	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
	}


	@Override
	public Result add(ResumeForAddDto resume) {
		
		Result businessRulesResult = BusinessRules.run();
		if(businessRulesResult != null) return businessRulesResult;
		
		Employee employee = employeeService.getById(resume.getEmployeeId()).getData();
		
		Resume resumeToAdd = new Resume(resume.getGithubAdress(),
				resume.getLinkedinAdress(),
				resume.getCoverLetter(),
				this.fileService.upload(resume.getPicture()),
				employee
				);
        resumeDao.save(resumeToAdd);
		
		this.resumeForeignLanguageService.addRange(resume.getForeignLanguages(), resumeToAdd);
        this.jobExperienceService.addRange(resume.getJobExperiences(), resumeToAdd);
        this.resumeSkillService.addRange(resume.getSkills(), resumeToAdd);

		
		return new SuccessResult("CV başarıyla kaydedildi.");
	}

	

}
