package com.java.namle.weatherAPI.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.java.namle.weatherAPI.dao.CloudsDao;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Clouds;

@Repository
@Transactional
public class CloudsDaoImpl implements CloudsDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void add(Clouds clouds) {
		entityManager.persist(clouds);

	}

	@Override
	public void update(Clouds clouds) {
		entityManager.merge(clouds);

	}

	@Override
	public void delete(Clouds clouds) {
		entityManager.remove(clouds);

	}

	@Override
	public Clouds getById(Long id) {

		return entityManager.find(Clouds.class, id);
	}

	@Override
	public List<Clouds> findClouds(SearchDTO searchDTO) {
		
		return null;
	}

}
