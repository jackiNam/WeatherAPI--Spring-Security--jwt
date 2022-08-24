package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Wind;

public interface WindDao {
	void add(Wind wind);

	void update(Wind wind);

	void delete(Wind wind);

	Wind getById(Long id);

	List<Wind> findWind(SearchDTO searchDTO);
}
