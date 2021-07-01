package com.kodlama.io.hrms.entities.dtos;

import com.kodlama.io.hrms.entities.concretes.City;
import com.kodlama.io.hrms.entities.concretes.Employer;
import com.kodlama.io.hrms.entities.concretes.JobPosition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForListingDto {
 
	private int id;
	private Employer employer;
	private City city;
	private JobPosition jobPosition;
}
