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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "foreign_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumeForeignLanguages"})
public class ForeignLanguage {
 
	@Column(name="foreignlang_id",nullable=false ,insertable = false,updatable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="name",nullable = false)
	private String name;
	
	@OneToMany(mappedBy="foreignLanguage")
	@JsonIgnore()
	Set<ResumeForeignLanguage> resumeForeignLanguages;

}
