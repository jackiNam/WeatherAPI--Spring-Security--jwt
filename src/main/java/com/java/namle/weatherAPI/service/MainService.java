package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.MainDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;

public interface MainService {
	void add(MainDTO mainDTO);

	void update(MainDTO mainDTO);

	void delete(Long id);

	MainDTO getById(Long id);

	List<MainDTO> findMain(SearchDTO searchDTO);

}
