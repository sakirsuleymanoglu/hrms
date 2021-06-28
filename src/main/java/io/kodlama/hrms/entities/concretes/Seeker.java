package io.kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.kodlama.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seeker {

	public Seeker(String nationalityId, String name, String surname, String dateOfBirth) {
		this.nationalityId = nationalityId;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public Seeker(User user, String nationalityId, String name, String surname, String dateOfBirth) {
		this.user = user;
		this.nationalityId = nationalityId;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "nationality_id")
	@NotBlank
	@NotNull
	private String nationalityId;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "surname")
	@NotBlank
	@NotNull
	private String surname;

	@Column(name = "date_of_birth")
	@NotBlank
	@NotNull
	private String dateOfBirth;
	
	@OneToOne(mappedBy = "seeker")
	private CurriculumVitae curriculumVitae;
}
