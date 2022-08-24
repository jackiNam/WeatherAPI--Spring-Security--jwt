package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Weather;

public interface WeatherDao {
	void add(Weather weather);

	void update(Weather weather);

	void delete(Weather weather);

	Weather getById(Long id);

	List<Weather> findWeather(SearchDTO searchDTO);
}
