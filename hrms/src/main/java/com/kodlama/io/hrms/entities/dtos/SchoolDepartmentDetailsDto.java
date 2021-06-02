package com.kodlama.io.hrms.entities.dtos;


import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDepartmentDetailsDto {
  private String department;
  private Date startDate;
  private Date graduateDate;
  private String schoolName;
}
