package com.kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlama.io.hrms.entities.concretes.SchoolDepartment;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer>{

	@Query("Select new com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto"
			+ "(sd.department,es.startDate,es.graduateDate,sd.school.name) From SchoolDepartment sd JOIN sd.employeeSchoolDepartments es "
			+ "Where es.employee.userId=:userId Order By es.graduateDate DESC")
	List<SchoolDepartmentDetailsDto> findByEmployeeSchoolDepartments_Employee_UserId(int userId);
}
