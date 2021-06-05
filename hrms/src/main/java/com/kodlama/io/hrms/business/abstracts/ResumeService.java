package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ResumeForAddDto;
import com.kodlama.io.hrms.entities.dtos.ResumeWithDetailsDto;

public interface ResumeService {
	DataResult<ResumeWithDetailsDto> getResumeWithDetails(int id);
	DataResult<List<Resume>> getAll();
	Result add(ResumeForAddDto resume);
}
