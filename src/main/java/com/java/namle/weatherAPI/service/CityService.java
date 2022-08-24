package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.CityDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;

public interface CityService {
	void add(CityDTO cityDTO);

	void update(CityDTO cityDTO);

	void delete(Long id);

	CityDTO getById(Long id);

	List<CityDTO> findCity(SearchDTO searchDTO);


	
}
