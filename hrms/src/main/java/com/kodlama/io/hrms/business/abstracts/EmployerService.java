package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.Employer;
import com.kodlama.io.hrms.entities.concretes.dtos.EmployerForRegisterDto;

public interface EmployerService {
   DataResult<List<Employer>> getAll();
   Result register(EmployerForRegisterDto employer);
}
