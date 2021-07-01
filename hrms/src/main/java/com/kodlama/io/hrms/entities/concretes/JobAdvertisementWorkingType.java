package com.kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Data
@Table(name="jobadvertisements_workingtypes")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementWorkingType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="workingType_id",nullable=false)
	private int workingType_id;
	
	
	@Column(name="description",nullable = false,unique = true)
	private String description;
	
	@JsonIgnore()
	@OneToMany(mappedBy="workingType",fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
}
