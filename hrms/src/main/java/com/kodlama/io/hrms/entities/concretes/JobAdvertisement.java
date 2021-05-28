package com.kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Data
@Table(name="jobAdvertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="jobDescription",nullable=false)
	private String jobDescription;
	
	@Column(name="minSalary",nullable=true)
	private Double minSalary;
	
	@Column(name="maxSalary",nullable=true)
	private Double maxSalary;
	
	@Column(name="openPositionCount",nullable=false)
	private int openPositionCount;
	
	
	@Column(name="lastApplyDate",nullable=false)
	private Date lastApplyDate;
	
	@Column(name="createDate",nullable=false)
	private Date createDate;
	
	@Column(name="isActive",nullable=false)
	private boolean isActive;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="cityid")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="jobpositionid")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employerid")
	private Employer employer;

	public JobAdvertisement(String jobDescription, Double minSalary, Double maxSalary, int openPositionCount,
			Date lastApplyDate, Date createDate, boolean isActive) {
		super();
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionCount = openPositionCount;
		this.lastApplyDate = lastApplyDate;
		this.createDate = createDate;
		this.isActive = isActive;
	}

	

	
	
}
