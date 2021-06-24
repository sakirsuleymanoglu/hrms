package io.kodlama.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {
	
	@NotBlank
	@NotNull
	private String companyName;
	
	@NotBlank
	@NotNull
	private String webSite;
	
	@NotBlank
	@NotNull
	private String telephoneNumber;
	
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String confirmPassword;
}
