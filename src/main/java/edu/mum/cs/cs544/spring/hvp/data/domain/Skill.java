package edu.mum.cs.cs544.spring.hvp.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill", catalog = "hvp")
public class Skill implements java.io.Serializable {
	private static final long serialVersionUID = 8876954785318344124L;
	private int id;
	private String description;
	private int years;

	public Skill() {
	}

	public Skill(int id, String description, int years) {
		this.id = id;
		this.description = description;
		this.years = years;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "description", nullable = false, length = 56)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "years", nullable = false)
	public int getYears() {
		return this.years;
	}

	public void setYears(int years) {
		this.years = years;
	}

}
