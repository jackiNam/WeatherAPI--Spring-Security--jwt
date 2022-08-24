package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Clouds;

public interface CloudsDao {
	void add(Clouds clouds);

	void update(Clouds clouds);

	void delete(Clouds clouds);

	Clouds getById(Long id);
	
	List<Clouds> findClouds(SearchDTO searchDTO);
}
