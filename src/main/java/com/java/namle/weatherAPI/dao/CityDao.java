package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.City;

public interface CityDao {
	void add(City city);

	void update(City city);

	void delete(City city);

	City getById(Long id);

	List<City> findCity(SearchDTO searchDTO);
}
