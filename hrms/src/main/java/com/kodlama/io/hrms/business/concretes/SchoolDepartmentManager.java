package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService{

	private SchoolDepartmentDao schoolDepartmentDao;
	
	@Autowired
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
		super();
		this.schoolDepartmentDao = schoolDepartmentDao;
	}

	@Override
	public DataResult<List<SchoolDepartmentDetailsDto>> findByEmployeeSchoolDepartments_Employee_UserId(int id) {
		
		return new SuccessDataResult<List<SchoolDepartmentDetailsDto>>(schoolDepartmentDao.findByEmployeeSchoolDepartments_Employee_UserId(id));
	}

}
