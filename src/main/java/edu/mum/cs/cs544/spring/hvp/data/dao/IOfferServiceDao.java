package edu.mum.cs.cs544.spring.hvp.data.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs.cs544.spring.hvp.data.domain.OfferService;

public interface IOfferServiceDao extends CrudRepository<OfferService, Integer>, IOfferServiceDaoCustom {
	
}
