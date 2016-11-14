package edu.mum.cs.cs544.spring.hvp.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.data.domain.User;

public interface ProjectDao extends JpaRepository<Project, Long>, ProjectDaoCustom {
	List<Project> getProjectsByNameAndLocation(String name, String location);
	/**
	 * List projects and tasks where a volunteer have offered services, ordered by time of the task.
	 * @param user
	 * @return List of projects
	 */
	@Query("select distinct p from Project p join p.taskList t join t.users u where u =:user")
	List<Project> getProjects(User user);
}
