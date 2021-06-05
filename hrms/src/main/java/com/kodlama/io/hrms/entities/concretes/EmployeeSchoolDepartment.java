package com.kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="employee_school_departments")
public class EmployeeSchoolDepartment {
	
	@Id
	@Column(name="employee_school_department_id")
	private int id;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name="school_department_id")
    private SchoolDepartment schoolDepartment;
    
    
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "graduate_date")
	private Date graduateDate;

	public EmployeeSchoolDepartment(Employee employee, SchoolDepartment schoolDepartment, Date startDate,
			Date graduateDate) {
		super();
		this.employee = employee;
		this.schoolDepartment = schoolDepartment;
		this.startDate = startDate;
		this.graduateDate = graduateDate;
	}

	


}
