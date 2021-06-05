package com.kodlama.io.hrms.business.abstracts;

import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.EmployeeSchoolDepartment;

public interface EmployeeSchoolDepartmentService {
    Result add(EmployeeSchoolDepartment employeeSchoolDepartment);
}
