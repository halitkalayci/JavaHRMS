package com.kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.SystemUserService;
import com.kodlama.io.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {
  private SystemUserService systemUserService;
@Autowired
public SystemUsersController(SystemUserService systemUserService) {
	super();
	this.systemUserService = systemUserService;
}


@GetMapping("/getall")
public List<SystemUser> getAll(){
	return systemUserService.getAll();
}
  
}
