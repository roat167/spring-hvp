package edu.mum.cs.cs544.spring.hvp.data.dao.impl;

import java.util.List;

import javax.persistence.Query;

import edu.mum.cs.cs544.spring.hvp.data.dao.GenericDao;
import edu.mum.cs.cs544.spring.hvp.data.dao.IProjectDaoCustom;
import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.data.domain.Skill;

public class ProjectDaoImpl extends GenericDao<Project, Integer> implements IProjectDaoCustom {

	public ProjectDaoImpl(Class<Project> persistentClass) {
		super(persistentClass);	
	}

//	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsByStatus(short status) {
		Query query = getEntityManager()
				.createQuery("from Project p where p.status = :status");
		query.setParameter("status", status);
		return query.getResultList();
	}

//	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsBySkillList(Skill skillList) {
		Query query = getEntityManager()
				.createQuery("select distinct p from Project p join p.taskList t join t.skillSet s where s =:skill");
		query.setParameter("skill", skillList);
		return query.getResultList();	
	}

//	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsByNameAndLocation(String name, String location) {
		Query query = getEntityManager()
				.createQuery("from Project p where p.name =:name and p.location =:location");
		query.setParameter("name", name);
		query.setParameter("location", location);
		return query.getResultList();
	}

	/*
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsByUser(User user) {
		Query query = getEntityManager()
				.createQuery("select distinct p from Project p join p.taskList t join t.users u where u =:user");
		query.setParameter("user", user);
		return query.getResultList();
	}
	*/
}
