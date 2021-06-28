package io.kodlama.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.kodlama.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

	public Employer(User user, String companyName, String webSite, String telephoneNumber, boolean status) {
		this.user = user;
		this.companyName = companyName;
		this.webSite = webSite;
		this.telephoneNumber = telephoneNumber;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_site")
	private String webSite;

	@Column(name = "telephone_number")
	private String telephoneNumber;

	@Column(name = "status")
	private boolean status;

	@OneToMany(mappedBy = "employer")
	private List<Advertisement> advertisements;

}
