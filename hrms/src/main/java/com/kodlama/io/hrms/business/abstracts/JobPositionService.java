package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
    JobPosition getByPositionName(String positionName);
    DataResult<JobPosition> getById(int id);
    Result addNew(JobPosition jobPosition);
}
