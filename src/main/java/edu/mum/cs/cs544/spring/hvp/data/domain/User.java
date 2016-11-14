package edu.mum.cs.cs544.spring.hvp.data.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", catalog = "hvp", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {
	private static final long serialVersionUID = -7877578994828490437L;
	private int id;
	private Person person;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(int id, Person person, String username, String password) {
		this.id = id;
		this.person = person;
		this.username = username;
		this.password = password;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Column(name = "username", unique = true, nullable = false, length = 26)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 26)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany
	@JoinTable(name="user_role", catalog="hvp",
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
