package com.kodlama.io.hrms.api.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.ResumeService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.entities.concretes.Resume;
import com.kodlama.io.hrms.entities.dtos.ResumeForAddDto;
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
	
	@PostMapping("/add")
	public ResponseEntity<?> addNew(@Valid @RequestBody ResumeForAddDto resume) {
		return ResponseEntity.ok(resumeService.add(resume));
	}

	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		return this.resumeService.getAll();
	}
	@GetMapping("/getDetailsById")
	public DataResult<ResumeWithDetailsDto> getDetailsById(int id){
		return this.resumeService.getResumeWithDetails(id);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}

}
