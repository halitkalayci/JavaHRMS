package com.kodlama.io.hrms.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "foreign_languages")
public class ForeignLanguage {
 
	@Column(name="id",nullable=false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="id",nullable = false)
	private String name;
	

	 @OneToMany(mappedBy="foreignLanguage")
	 Set<ResumeForeignLanguage> resumeForeignLanguages;
}
