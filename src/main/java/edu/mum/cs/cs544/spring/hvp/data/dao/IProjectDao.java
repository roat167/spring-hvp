package edu.mum.cs.cs544.spring.hvp.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs544.spring.hvp.data.domain.Project;

public interface IProjectDao extends JpaRepository<Project, Integer>, IProjectDaoCustom {	
}
