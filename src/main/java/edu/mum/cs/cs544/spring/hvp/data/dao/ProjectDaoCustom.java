package edu.mum.cs.cs544.spring.hvp.data.dao;

import java.util.List;

import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.data.domain.Skill;

public interface ProjectDaoCustom {
	//List projects by status
	List<Project> getProjects(short status);
	//Look for projects that requires a particular type of resource/skill
	List<Project> getProjectsBySkillList(Skill skillList);
	//Search projects by keywords and location
	//List<Project> getProjectsByNameAndLocation(String name, String location);
	void update(Project project);
	
}
