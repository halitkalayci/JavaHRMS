package com.kodlama.io.hrms.entities.serializers;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.concretes.SchoolDepartment;

import lombok.Data;

@Embeddable
@Data
public class EmployeeSchoolDepartmentId implements Serializable{

	 private Employee employee;

	 private SchoolDepartment schoolDepartment;
	
	public int hashCode() {
		return employee.getUserId()+schoolDepartment.getId();
	}
	
	public boolean equals(Object object) {
	    if (object instanceof EmployeeSchoolDepartmentId) {
	    	EmployeeSchoolDepartmentId otherId = (EmployeeSchoolDepartmentId) object;
	      return (otherId.schoolDepartment.getId() == this.schoolDepartment.getId()) 
	              && (otherId.employee.getUserId() == this.employee.getUserId());
	    }
	    return false;
	  }

}
