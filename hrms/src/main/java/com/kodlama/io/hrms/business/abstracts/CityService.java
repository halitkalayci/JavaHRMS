package com.kodlama.io.hrms.business.abstracts;

import java.util.List;

import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.concretes.City;

public interface CityService {
       DataResult<List<City>> getAll();
       DataResult<City> getById(int id);
}
