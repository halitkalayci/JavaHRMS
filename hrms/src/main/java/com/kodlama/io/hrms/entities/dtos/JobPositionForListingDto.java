package com.kodlama.io.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPositionForListingDto {
	  private int id;
      private String positionName;
      private long count;
}
