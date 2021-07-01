package com.kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.EmployerUpdateRequest;

public interface EmployerUpdateRequestDao extends JpaRepository<EmployerUpdateRequest, Integer>{
       EmployerUpdateRequest getByEmployer_UserIdAndIsApprovedIsNull(int employerId);
}
