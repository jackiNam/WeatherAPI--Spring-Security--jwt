package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.CloudsDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;

public interface CloudsService {
	void add(CloudsDTO cloudsDTO);

	void update(CloudsDTO cloudsDTO);

	void delete(Long id);

	CloudsDTO getById(Long id);

	List<CloudsDTO> findClouds(SearchDTO searchDTO);

}
