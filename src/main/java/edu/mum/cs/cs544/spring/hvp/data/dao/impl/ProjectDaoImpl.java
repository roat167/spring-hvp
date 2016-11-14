package edu.mum.cs.cs544.spring.hvp.data.dao.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.mum.cs.cs544.spring.hvp.data.dao.ProjectDaoCustom;
import edu.mum.cs.cs544.spring.hvp.data.domain.Project;
import edu.mum.cs.cs544.spring.hvp.data.domain.Skill;

public class ProjectDaoImpl implements ProjectDaoCustom {
	private static final Log logger = LogFactory.getLog(ProjectDaoCustom.class);
	@PersistenceContext 
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjects(short status) {
		Query query = getEntityManager()
				.createQuery("from Project p where p.status = :status");
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjectsBySkillList(Skill skillList) {
		Query query = getEntityManager()
				.createQuery("select distinct p from Project p join p.taskList t join t.skillSet s where s =:skill");
		query.setParameter("skill", skillList);
		return query.getResultList();	
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<Project> getProjectsByNameAndLocation(String name, String location) {
//		Query query = getEntityManager()
//				.createQuery("from Project p where p.name =:name and p.location =:location");
//		query.setParameter("name", name);
//		query.setParameter("location", location);
//		return query.getResultList();
//	}

	/*
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjects(User user) {
		Query query = getEntityManager()
				.createQuery("select distinct p from Project p join p.taskList t join t.users u where u =:user");
		query.setParameter("user", user);
		return query.getResultList();
	}
	*/
	@Override
	public void update(Project project) {
		try {
			getEntityManager().merge(project);
			getEntityManager().flush();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
