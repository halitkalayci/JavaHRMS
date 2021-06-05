package com.kodlama.io.hrms.entities.concretes;


import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="skills")
public class Skill {
	   @Id()
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "skill_id")
	   private int id;
	   
	   @Column(name = "name",nullable = false)
	   private String name;
   
	   @OneToMany(mappedBy="skill")
       @JsonIgnore()
	   Set<ResumeSkill> resumeSkills;
		 
}
