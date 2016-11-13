package edu.mum.cs.cs544.spring.hvp.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task", catalog = "hvp")
public class Task implements java.io.Serializable {
	private static final long serialVersionUID = 1089077518414238405L;
	private int id;
	private String name;
	private short status;
	private String description;
	private Date startDate;
	private Date endDate;
	private List<Skill> skillSet = new ArrayList<Skill>();
	private Project project;
	private List<User> users;

	public Task() {
	}

	public Task(int id, String name, short status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Task(int id, String name, short status, String description, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Task(String name, short status, String description, Date startDate, Date endDate) {		
		this.name = name;
		this.status = status;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
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

	@Column(name = "name", nullable = false, length = 26)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	@Column(name = "description", length = 56)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startDate", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endDate", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToMany
	@JoinTable(name = "skill_list" , catalog="hvp",
	joinColumns=@JoinColumn(name="task_id"), inverseJoinColumns=@JoinColumn(name="skill_id"))
	public List<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	@ManyToOne
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	@ManyToMany
	@JoinTable(name = "offer_service" , catalog="hvp",
	joinColumns=@JoinColumn(name="task_id"), inverseJoinColumns=@JoinColumn(name="user_id"))
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


}
