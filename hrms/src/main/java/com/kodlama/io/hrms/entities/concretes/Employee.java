package com.kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="Employees")
public class Employee {
	@Id
	@Column(name="`UserId`",nullable=false)
	private int userId;
	
	@Column(name="`FirstName`",nullable=false)
	private String firstName;
	
	@Column(name="`LastName`",nullable=false)
	private String lastName;
	
	
	@Column(name="`NationalityId`",unique=true,nullable=false)
	private String nationalityId;
	
	@Column(name="`BirthOfDate`",nullable=false)
	private Date birthOfDate;
	
}
