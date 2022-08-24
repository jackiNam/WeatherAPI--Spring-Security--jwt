package com.java.namle.weatherAPI.dao;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.Coord;

public interface CoordDao {
	void add(Coord coord);
	void update(Coord coord);
	void delete(Coord coord);
	Coord getById(Long id);
	List<Coord> findCoord(SearchDTO searchDTO);
}
