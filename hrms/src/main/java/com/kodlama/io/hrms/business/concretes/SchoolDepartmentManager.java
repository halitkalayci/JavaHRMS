package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.EmployeeSchoolDepartmentService;
import com.kodlama.io.hrms.business.abstracts.EmployeeService;
import com.kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessResult;
import com.kodlama.io.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import com.kodlama.io.hrms.entities.concretes.EmployeeSchoolDepartment;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentForAddDto;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService{

	private SchoolDepartmentDao schoolDepartmentDao;
	private EmployeeSchoolDepartmentService employeeSchoolDepartmentService;
	private EmployeeService employeeService;
	
	@Autowired
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao,
			EmployeeSchoolDepartmentService employeeSchoolDepartmentService,
			EmployeeService employeeService) {
		super();
		this.schoolDepartmentDao = schoolDepartmentDao;
		this.employeeSchoolDepartmentService = employeeSchoolDepartmentService;
		this.employeeService = employeeService;
	}

	@Override
	public DataResult<List<SchoolDepartmentDetailsDto>> findByEmployeeSchoolDepartments_Employee_UserId(int id) {
		
		return new SuccessDataResult<List<SchoolDepartmentDetailsDto>>(schoolDepartmentDao.findByEmployeeSchoolDepartments_Employee_UserId(id));
	}

	@Override
	public Result assignToEmployee(SchoolDepartmentForAddDto schoolDepartment) {
		this.employeeSchoolDepartmentService.add(new EmployeeSchoolDepartment(
				employeeService.getById(schoolDepartment.getEmployee().getUserId()).getData(),
				this.schoolDepartmentDao.getOne(schoolDepartment.getSchoolDepartment().getId()),
				schoolDepartment.getStartDate(),
				schoolDepartment.getEndDate()
				));
		return new SuccessResult();
	}



}
