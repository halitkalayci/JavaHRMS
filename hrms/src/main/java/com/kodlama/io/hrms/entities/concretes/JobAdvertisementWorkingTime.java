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
@Table(name="jobadvertisements_workingtimes")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementWorkingTime {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="workingTime_id",nullable=false)
	private int workingTime_id;
	
	
	@Column(name="description",nullable = false,unique = true)
	private String description;
	
	@JsonIgnore()
	@OneToMany(mappedBy="workingTime",fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
}
