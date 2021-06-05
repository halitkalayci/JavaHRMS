package com.kodlama.io.hrms.entities.dtos;



import java.util.Date;
import java.util.List;

import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.JobExperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWithDetailsDto {
	private int Id;
    private String githubAddress;
    private String linkedinAddress;
    private String coverLetter;
    private String picture;
    private Date createDate;
    private Employee employee;
    
    private List<JobExperience> jobExperiences;
    private List<SchoolDepartmentDetailsDto> schoolDepartments;
    private List<ForeignLanguageDetailsDto> foreignLanguages;
    private List<SkillDetailsDto> skills;

	public ResumeWithDetailsDto(int id, String githubAddress, String linkedinAddress, String coverLetter,
			String picture, Date createDate, Employee employee) {
		super();
		Id = id;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.coverLetter = coverLetter;
		this.picture = picture;
		this.createDate = createDate;
		this.employee = employee;
	}
    
    
}
