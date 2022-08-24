package com.java.namle.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.java.namle.weatherAPI.dao.SysDao;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Sys;

@Repository
@Transactional
public class SysDaoImpl implements SysDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Sys sys) {
		entityManager.persist(sys);

	}

	@Override
	public void update(Sys sys) {
		entityManager.merge(sys);

	}

	@Override
	public void delete(Sys sys) {
		entityManager.remove(sys);

	}

	@Override
	public Sys getById(Long id) {
		
		return entityManager.find(Sys.class, id);
	}

	@Override
	public List<Sys> findSys(SearchDTO searchDTO) {
		
		return null;
	}

}
