package edu.mum.cs.cs544.spring.hvp.data.dao;

import java.util.List;

import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.data.domain.Skill;

public interface IProjectDaoCustom {
	//List projects by status
	List<Project> getProjectsByStatus(short status);
	//Look for projects that requires a particular type of resource/skill
	List<Project> getProjectsBySkillList(Skill skillList);
	//Search projects by keywords and location
	List<Project> getProjectsByNameAndLocation(String name, String location);
	//List projects and tasks where a volunteer have offered services, ordered by time of the task.
	//List<Project> getProjectsByUser(User user);
}
