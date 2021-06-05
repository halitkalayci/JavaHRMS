package com.kodlama.io.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeForAddDto {
	

	private String githubAdress;
	private String linkedinAdress;
	private String coverLetter;
	private MultipartFile picture;
	
	private int employeeId;
	@Valid
	private List<ForeignLanguageForAddDto> foreignLanguages;
	
	@Valid
	private List<SkillForAddDto> skills;
	
	@Valid
	private List<JobExperienceForAddDto> jobExperiences;
}
