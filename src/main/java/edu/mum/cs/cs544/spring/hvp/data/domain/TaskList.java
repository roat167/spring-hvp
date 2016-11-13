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
@Table(name = "task_list", catalog = "hvp")
public class TaskList implements Serializable {
	private static final long serialVersionUID = 8630596894789395735L;
	private int taskListId;
	private Project project;
	private Task task;	

	@Id
	@GeneratedValue
	@Column(name="task_list_id", nullable = false)
	public int getTaskListId() {
		return taskListId;
	}

	public void setTaskListId(int taskListId) {
		this.taskListId = taskListId;
	}

	@ManyToOne
	@JoinColumn(name="project_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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
