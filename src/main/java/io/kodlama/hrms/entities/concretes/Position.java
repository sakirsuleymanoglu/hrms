package io.kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position {

	@Column(name = "id")
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	public Position() {

	}

	public Position(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionName() {
		return name;
	}

	public void setPositionName(String name) {
		this.name = name;
	}
}
