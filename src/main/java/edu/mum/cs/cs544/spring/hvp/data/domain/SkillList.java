package edu.mum.cs.cs544.spring.hvp.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "skill_list", catalog = "hvp")
public class SkillList implements Serializable {
	private static final long serialVersionUID = 8630596894789395735L;
	private int skillListId;
	private Skill skill;
	private Task task;	

	@Id
	@GeneratedValue
	@Column(name="skill_list_id", nullable = false)
	public int getSkillListId() {
		return skillListId;
	}

	public void setSkillListId(int skillListId) {
		this.skillListId = skillListId;
	}

	@ManyToOne
	@JoinColumn(name="skill_id")
	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	@ManyToOne
	@JoinColumn(name="task_id")
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
}
