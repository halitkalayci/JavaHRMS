package com.kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.hrms.business.abstracts.EmployeeJobAdvertisementFavoriteService;
import com.kodlama.io.hrms.core.utilities.results.DataResult;
import com.kodlama.io.hrms.core.utilities.results.Result;
import com.kodlama.io.hrms.entities.concretes.EmployeeJobAdvertisementFavorite;
import com.kodlama.io.hrms.entities.dtos.JobAdvertisementFavoriteToToggleDto;

@RestController
@RequestMapping("/api/employeeJobAdFavorites")
@CrossOrigin
public class EmployeeJobAdvertisementFavoritesController {

	private EmployeeJobAdvertisementFavoriteService employeeJobAdvertisementFavoriteService;
	@Autowired
	public EmployeeJobAdvertisementFavoritesController(
			EmployeeJobAdvertisementFavoriteService employeeJobAdvertisementFavoriteService) {
		super();
		this.employeeJobAdvertisementFavoriteService = employeeJobAdvertisementFavoriteService;
	}

	@GetMapping("/getByUserId")
	public DataResult<List<EmployeeJobAdvertisementFavorite>> getByUserId(int id){
	return employeeJobAdvertisementFavoriteService.getByEmployeeId(id);
	}
	@PostMapping("/addToFavorites")
	public Result addToFavorites(@RequestBody JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto) {
		return employeeJobAdvertisementFavoriteService.addNew(jobAdvertisementAddToFavoriteDto);
	}
	@PostMapping("/removeFromFavorites")
	public Result removeFromFavorites(@RequestBody JobAdvertisementFavoriteToToggleDto jobAdvertisementAddToFavoriteDto) {
		return employeeJobAdvertisementFavoriteService.remove(jobAdvertisementAddToFavoriteDto);
	}
	
}
