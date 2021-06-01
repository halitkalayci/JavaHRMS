package com.kodlama.io.hrms.entities.concretes;



import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Employees")
@AllArgsConstructor
@NoArgsConstructor
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
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="`UserId`")
	private User user;
	
	@OneToMany(mappedBy="employee")
	Set<EmployeeSchoolDepartment> employeeSchoolDepartments;

	public Employee(int userId, String firstName, String lastName, String nationalityId, Date birthOfDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthOfDate = birthOfDate;
	}
}
