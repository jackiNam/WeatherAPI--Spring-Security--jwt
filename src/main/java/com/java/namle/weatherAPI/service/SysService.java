package com.java.namle.weatherAPI.service;

import java.util.List;

import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.SysDTO;

public interface SysService {
	void add(SysDTO sysDTO);

	void update(SysDTO sysDTO);

	void delete(Long id);

	SysDTO getById(Long id);

	List<SysDTO> findSys(SearchDTO searchDTO);

}
