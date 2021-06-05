package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.Employee;
import com.kodlama.io.hrms.entities.dtos.EmployeeForRegisterDto;

public interface EmployeeService {
     DataResult<List<Employee>> getAll();
     Result register(EmployeeForRegisterDto employee);
     DataResult<Employee> getById(int id);
}
