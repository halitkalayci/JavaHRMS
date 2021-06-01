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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="resume_foreign_languages")
public class ResumeForeignLanguage {

	@Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "ratio")
	private int ratio;
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@ManyToOne()
	@JoinColumn(name ="foreign_language_id")
	private ForeignLanguage foreignLanguage;
}
