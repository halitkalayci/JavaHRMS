package com.kodlama.io.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.ResumeService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ResumeWithDetailsDto;

@RestController
@RequestMapping("/api/resumees")
public class ResumeesController {

	private ResumeService resumeService;

	@Autowired
	public ResumeesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	@GetMapping("/getByUserId")
	public DataResult<ResumeWithDetailsDto> getByUserId(int id){
		return this.resumeService.getResumeWithDetails(id);
	}
	
	

}
