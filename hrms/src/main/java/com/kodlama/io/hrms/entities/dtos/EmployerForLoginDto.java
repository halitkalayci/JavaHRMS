package com.kodlama.io.hrms.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForLoginDto {
	  @NotNull(message = "Telefon boş olamaz.")
	  @NotBlank(message = "Telefon boş olamaz.")
      private String phone;
	  @NotNull(message = "Şifre boş olamaz.")
	  @NotBlank(message = "Şifre boş olamaz.")
      private String password;
}
