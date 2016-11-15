package edu.mum.cs.cs544.spring.hvp.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiary", catalog = "hvp")
public class Beneficiary implements java.io.Serializable {
	private static final long serialVersionUID = 2615506743164623624L;
	private Long id;
	private String name;
	private String description;

	public Beneficiary() {
	}

	public Beneficiary(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 26)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 56)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
