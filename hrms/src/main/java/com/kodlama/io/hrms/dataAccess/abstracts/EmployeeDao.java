package com.kodlama.io.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{
      Employee findByNationalityId(String nationalityId);
}
