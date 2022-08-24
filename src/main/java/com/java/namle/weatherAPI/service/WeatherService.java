package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.WeatherDTO;

public interface WeatherService {
	void add(WeatherDTO weatherDTO);

	void update(WeatherDTO weatherDTO);

	void delete(Long id);

	WeatherDTO getById(Long id);

	List<WeatherDTO> findWeather(SearchDTO searchDTO);

}
