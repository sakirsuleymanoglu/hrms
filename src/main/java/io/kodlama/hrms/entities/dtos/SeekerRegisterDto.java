package io.kodlama.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeekerRegisterDto {
	private String name;
	private String surname;
	private String nationalityId;
	private String dateOfBirth;
	private String email;
	private String password;
	private String confirmPassword;
}
