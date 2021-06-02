package com.kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.dtos.SchoolDepartmentDetailsDto;

@RestController
@RequestMapping("/api/schooldepartments")
public class SchoolDepartmentsController {

	private SchoolDepartmentService schoolDepartmentService;
	
	@Autowired
	public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
		super();
		this.schoolDepartmentService = schoolDepartmentService;
	}


	@GetMapping("/getByUserId")
	public DataResult<List<SchoolDepartmentDetailsDto>> getByUserId(int id){
		return schoolDepartmentService.findByEmployeeSchoolDepartments_Employee_UserId(id);
	}
}
