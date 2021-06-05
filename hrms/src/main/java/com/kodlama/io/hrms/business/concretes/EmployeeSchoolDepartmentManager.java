package com.kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.EmployeeSchoolDepartmentService;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.EmployeeSchoolDepartmentDao;
import com.kodlama.io.hrms.entities.concretes.EmployeeSchoolDepartment;

@Service
public class EmployeeSchoolDepartmentManager implements EmployeeSchoolDepartmentService{

	@Autowired
	private EmployeeSchoolDepartmentDao employeeSchoolDepartmentDao;
	@Override
	public Result add(EmployeeSchoolDepartment employeeSchoolDepartment) {
		this.employeeSchoolDepartmentDao.save(employeeSchoolDepartment);
		return new SuccessResult();
	}

}
