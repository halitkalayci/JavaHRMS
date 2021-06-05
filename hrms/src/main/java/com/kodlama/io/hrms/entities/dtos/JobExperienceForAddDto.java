package com.kodlama.io.hrms.entities.dtos;

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
      private Date startDate;

      private Date endDate;
}
