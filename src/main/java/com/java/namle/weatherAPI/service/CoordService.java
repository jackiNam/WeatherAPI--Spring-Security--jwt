package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.CoordDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;

public interface CoordService {
	void add(CoordDTO coordDTO);

	void update(CoordDTO coordDTO);

	void delete(Long id);

	CoordDTO getById(Long id);

	List<CoordDTO> findCoord(SearchDTO searchDTO);

}
