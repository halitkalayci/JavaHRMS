package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentForAddDto;

public interface SchoolDepartmentService {

	DataResult<List<SchoolDepartmentDetailsDto>> findByEmployeeSchoolDepartments_Employee_UserId(int id);
	Result assignToEmployee(SchoolDepartmentForAddDto schoolDepartment);
}
