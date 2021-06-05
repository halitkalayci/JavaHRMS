package com.kodlama.io.hrms.entities.dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.SchoolDepartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDepartmentForAddDto {

	@NotNull
	private SchoolDepartment schoolDepartment;
	@NotNull
	private Employee employee;
	@NotNull
	private Date startDate;
	private Date endDate;
}
