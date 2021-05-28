package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.io.hrms.entities.concretes.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> findByIsActiveTrue();
    DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();
    DataResult<List<JobAdvertisement>> findByEmployer_EmployerId(int employerId);
    Result addNew(JobAdvertisementForAddDto jobAdvertisement);
    Result changeStatus(int advertisementId, int employerId);
}
