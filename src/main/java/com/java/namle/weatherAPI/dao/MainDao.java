package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Main;

public interface MainDao {
	void add(Main main);

	void update(Main main);

	void delete(Main main);

	Main getById(Long id);

	List<Main> findMain(SearchDTO searchDTO);
}
