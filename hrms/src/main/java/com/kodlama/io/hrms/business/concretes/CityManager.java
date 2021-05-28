package com.kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.hrms.business.abstracts.CityService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import com.kodlama.io.hrms.dataAccess.abstracts.CityDao;
import com.kodlama.io.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		City city = cityDao.findById(id);
		if(city==null) return new ErrorDataResult<City>();
		return new SuccessDataResult<City>(city);
	}

	

}
