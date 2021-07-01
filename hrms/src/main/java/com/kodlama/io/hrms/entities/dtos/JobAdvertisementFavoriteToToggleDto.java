package com.kodlama.io.hrms.entities.dtos;

import com.kodlama.io.hrms.entities.concretes.ForeignLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFavoriteToToggleDto {
	private int employeeId;
	private int jobAdvertisementId;
}
