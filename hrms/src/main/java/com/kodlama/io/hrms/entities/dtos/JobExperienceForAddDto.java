package com.kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceForAddDto {

	  @NotNull
	  @NotBlank
      private String officeName;

	  @NotNull
	  @NotBlank
      private String position;
      
	  @NotNull
      private LocalDate startDate;

      private Date endDate;
}
