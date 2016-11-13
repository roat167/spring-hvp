package edu.mum.cs.cs544.spring.hvp.data.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs.cs544.spring.hvp.data.domain.Skill;

public interface ISkillDao extends CrudRepository<Skill, Integer>, ISkillDaoCustom {

}
