package com.kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.JobPositionService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.JobPosition;
import com.kodlama.io.hrms.entities.dtos.JobPositionForListingDto;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	@GetMapping("/getAllWithJobAdCount")
	public DataResult<List<JobPositionForListingDto>> getAllWithJobAdCount(){
		return this.jobPositionService.getAllWithJobAdCount();
	}
	
	@GetMapping("/getbyname")
	public DataResult<JobPosition> getByPositionName(String positionName){
		return this.jobPositionService.getByPositionName(positionName);
	}
	@GetMapping("/getbyid")
	public DataResult<JobPosition> getById(int id){
		return this.jobPositionService.getById(id);
	}
	@PostMapping("add")
	public Result addNew(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.addNew(jobPosition);
	}
	
}
