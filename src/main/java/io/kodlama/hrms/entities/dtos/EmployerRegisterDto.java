package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {
	private String companyName;
	private String webSite;
	private String telephoneNumber;
	private String email;
	private String password;
	private String confirmPassword;
}
