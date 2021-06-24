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
public class SeekerRegisterDto {

	@NotBlank
	@NotNull
	private String name;

	@NotBlank
	@NotNull
	private String surname;

	@NotBlank
	@NotNull
	private String nationalityId;

	@NotBlank
	@NotNull
	private String dateOfBirth;

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
