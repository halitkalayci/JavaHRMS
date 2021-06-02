package com.kodlama.io.hrms.entities.concretes;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="resumes")
public class Resume {
	 @Id()
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "resume_id")
     private int id;
	 
	 
	 @Column(name = "github_adress" , nullable=true)
	 private String githubAddress;
	 
	 @Column(name = "linkedin_adress" , nullable=true)
	 private String linkedinAddress;
	 
	 @Column(name = "cover_letter" , nullable=true)
	 private String coverLetter;
	 
	 @Column(name = "picture" , nullable=true)
	 private String picture;
	 
	 @Column(name = "create_date" , nullable=false)
	 private Date createDate;
	 
	 

	 
	 @ManyToOne()
	 @JoinColumn(name = "employee_id")
	 @JsonIgnore
	 private Employee employee;
	 
	 @OneToMany(mappedBy="resume")
	 @JsonIgnore
	 private Set<JobExperience> jobExperiences;
	 
	 @OneToMany(mappedBy="resume")
	 @JsonIgnore()
	 Set<ResumeForeignLanguage> resumeForeignLanguages;
	 
	 
	 @ManyToMany()
	 @JsonIgnore
	 @JoinTable(
			   name = "resume_skills", 
			   joinColumns = @JoinColumn(name = "resume_id"), 
			   inverseJoinColumns = @JoinColumn(name = "skill_id"))
	 private Set<Skill> skills;
}
