package com.kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.io.hrms.entities.dtos.JobAdvertisementForAddDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	

	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getAllActive(){
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	@GetMapping("/getAllActiveOrderByDate")
	public DataResult<List<JobAdvertisement>> getAllActiveOrderDate(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderByCreateDate();
	}
	@GetMapping("/getAllActiveByEmployer")
	public DataResult<List<JobAdvertisement>> getAllActiveOrderDate(int employerId){
		return this.jobAdvertisementService.findByEmployer_EmployerId(employerId);
	}
	@PutMapping("/changestatus")
	public Result changeStatus(int jobadvertisementId, int employerId){
		return this.jobAdvertisementService.changeStatus(jobadvertisementId, employerId);
	}
	@PostMapping("/add")
	public Result addNew(@RequestBody JobAdvertisementForAddDto jobAdvertisement){
		return this.jobAdvertisementService.addNew(jobAdvertisement);
	}
	
}
