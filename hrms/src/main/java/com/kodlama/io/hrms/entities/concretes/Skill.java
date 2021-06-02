package com.kodlama.io.hrms.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="skills")
public class Skill {
	   @Id()
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id")
	   private int id;
	   
	   @Column(name = "name",nullable = false)
	   private String name;
	   
	   @ManyToMany()
	   @JsonIgnore
	   @JoinTable(
			   name = "resume_skills", 
			   joinColumns = @JoinColumn(name = "skill_id"), 
			   inverseJoinColumns = @JoinColumn(name = "resume_id"))
	   private Set<Resume> resumes;
}
