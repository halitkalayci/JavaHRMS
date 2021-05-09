package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();

}
