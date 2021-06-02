package com.kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.kodlama.io.hrms.entities.serializers.EmployeeSchoolDepartmentId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_school_departments")
@IdClass(EmployeeSchoolDepartmentId.class)
public class EmployeeSchoolDepartment {
	
	@Id
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    @Id
    @ManyToOne
    @JoinColumn(name="school_department_id")
    private SchoolDepartment schoolDepartment;
    
    
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "graduate_date")
	private Date graduateDate;



}
