package com.kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer>{
     City findById(int id);
}
