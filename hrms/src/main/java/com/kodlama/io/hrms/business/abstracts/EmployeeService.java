package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeService {
     List<Employee> getAll();
}
