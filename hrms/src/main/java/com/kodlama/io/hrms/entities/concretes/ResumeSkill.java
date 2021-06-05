package com.kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_skills")
public class ResumeSkill {

	@Id
	@Column(name="resume_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resume_skill_id;
	
    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;
    
    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
    
    
	@Column(name = "level")
	private int level;


	public ResumeSkill(Resume resume, Skill skill, int level) {
		super();
		this.resume = resume;
		this.skill = skill;
		this.level = level;
	}
	 
	
}
