package edu.mum.cs.cs544.spring.hvp.data.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs.cs544.spring.hvp.data.domain.Role;

public interface IRoleDao extends CrudRepository<Role, Integer>, IRoleDaoCustom {

}
