package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.WindDTO;

public interface WindService {
	void add(WindDTO windDTO);

	void update(WindDTO windDTO);

	void delete(Long id);

	WindDTO getById(Long id);

	List<WindDTO> findWind(SearchDTO searchDTO);

}
