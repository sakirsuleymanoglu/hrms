package io.kodlama.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.kodlama.hrms.entities.concretes.Employer;
import io.kodlama.hrms.entities.concretes.Seeker;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull
	private String email;

	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;

	@OneToOne(mappedBy = "user")
	private Seeker seeker;

	@OneToOne(mappedBy = "user")
	private Employer employer;
}
