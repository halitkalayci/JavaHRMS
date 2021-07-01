package com.kodlama.io.hrms.api.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kodlama.io.hrms.business.abstracts.EmployerUpdateRequestService;
import com.kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.dtos.EmployerUpdateRequestForAddDto;


@RestController
@RequestMapping("/api/employerupdaterequests")
@CrossOrigin
public class EmployerUpdateRequestsController {

	private EmployerUpdateRequestService employerUpdateRequestService;
	@Autowired
	public EmployerUpdateRequestsController(EmployerUpdateRequestService employerUpdateRequestService) {
		super();
		this.employerUpdateRequestService = employerUpdateRequestService;
	}
	
	@GetMapping("/canSubmitNewUpdateRequest")
	public Result canSubmitNewUpdateRequest(int id){
		return this.employerUpdateRequestService.canSubmitNewUpdateRequest(id);
	}
	@RequestMapping(value = "/addNew", method = RequestMethod.POST,
		    consumes = {"multipart/form-data"})
	public ResponseEntity<?> addNew(@Valid @RequestPart("updateRequest") EmployerUpdateRequestForAddDto employerUpdateRequestForAddDto, @RequestPart(name="avatar",required = false) MultipartFile avatar) {
		return ResponseEntity.ok( this.employerUpdateRequestService.addNew(employerUpdateRequestForAddDto,avatar) );
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
