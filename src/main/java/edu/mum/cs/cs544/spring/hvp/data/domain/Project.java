package edu.mum.cs.cs544.spring.hvp.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.cs.cs544.spring.hvp.util.CustomDateFormatter;

@Entity
@Table(name = "project", catalog = "hvp")
public class Project implements java.io.Serializable {
	private static final long serialVersionUID = 5699833322635029323L;
	private Long id;
	private String name;
	private short status;
	private String description;
	private Date startDate;
	private Date endDate;
	private List<Task> taskList = new ArrayList<Task>();
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	private List<Skill> skillList = new ArrayList<Skill>();
	// these transient is for adding new task...
	@Transient
	private Task task = new Task();
	@Transient
	private Beneficiary beneficiary = new Beneficiary();
	@Transient
	private Skill skill = new Skill();

	@Lob
	@Column(name = "image", length = 10000000)
	private byte[] image;
	private String location;

	public Project() {
	}

	public Project(Long id, String name, short status, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project(Long id, String name, short status, String description, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "startdate", nullable = false, length = 19)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enddate", nullable = false, length = 19)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// mappedBy="project",
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "task_list", catalog = "hvp", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "task_list_id"))
	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "project_beneficiary", catalog = "hvp", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "project_beneficiary_id"))
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "project_skills", catalog = "hvp", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "project_skills_id"))
	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	//Transient fields
	private String endDateDisplay;
	private String startDateDisplay;
	
	@Transient
	public String getEndDateDisplay() {
		this.setEndDateDisplay(CustomDateFormatter.displayDateFormat(this.getEndDate()));
		return this.endDateDisplay;
	}

	@Transient
	public String getStartDateDisplay() {
		this.setStartDateDisplay(CustomDateFormatter.displayDateFormat(this.getStartDate()));
		return this.startDateDisplay;
	}
	
	public void setEndDateDisplay(String endDateDisplay) {
		this.endDateDisplay = endDateDisplay;
	}

	public void setStartDateDisplay(String startDateDisplay) {
		this.startDateDisplay = startDateDisplay;
	}
}
