package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.EmployeeJobAdvertisementFavorite;
import com.kodlama.io.hrms.entities.dtos.JobAdvertisementFavoriteToToggleDto;

public interface EmployeeJobAdvertisementFavoriteService {
    DataResult<List<EmployeeJobAdvertisementFavorite>> getByEmployeeId(int id);
    Result addNew(JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto);
    Result remove(JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto);
}
