package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Sys;

public interface SysDao {
	void add(Sys sys);

	void update(Sys sys);

	void delete(Sys sys);

	Sys getById(Long id);

	List<Sys> findSys(SearchDTO searchDTO);
}
