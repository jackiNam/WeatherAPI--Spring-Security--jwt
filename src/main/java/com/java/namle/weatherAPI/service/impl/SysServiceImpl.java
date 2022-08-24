package com.java.namle.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.SysDao;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.SysDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Sys;
import com.java.namle.weatherAPI.service.SysService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class SysServiceImpl implements SysService {

	@Autowired
	SysDao sysDao;

	@Override
	public void add(SysDTO sysDTO) {
		Sys sys = convertToEntity(sysDTO);
		sysDao.add(sys);

	}

	@Override
	public void update(SysDTO sysDTO) {
		Sys sys = sysDao.getById(sysDTO.getId());
		if (sys != null) {

			sys = convertToEntity(sysDTO);
			sysDao.update(sys);

		}

	}

	@Override
	public void delete(Long id) {
		Sys sys = sysDao.getById(id);
		if (sys != null) {

			sysDao.delete(sys);
		}

	}

	@Override
	public SysDTO getById(Long id) {
		Sys sys = sysDao.getById(id);
		if (sys != null) {
			sysDao.getById(id);

		}
		return null;
	}

	@Override
	public List<SysDTO> findSys(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public SysDTO convertToDTO(Sys sys) {
		SysDTO sysDTO = new SysDTO();
		if (sys != null) {
			sysDTO.setId(sys.getIdSys());
			sysDTO.setIdSys(sys.getId());
			sysDTO.setCountry(sys.getCountry());
			sysDTO.setIdCity(sys.getCity().getId());
			sysDTO.setMessage(sys.getMessage());
			sysDTO.setSunrise(sys.getSunrise());
			sysDTO.setSunset(sys.getSunset());
			sysDTO.setType(sys.getType());
			sysDTO.setCreatedDate(DateTimeUtils.formatDate(sys.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

			return sysDTO;
		}

		return null;
	}

	public Sys convertToEntity(SysDTO sysDTO) {
		Sys sys = new Sys();
		if (sysDTO != null) {
			sys.setIdSys(sysDTO.getId());
			sys.setCountry(sysDTO.getCountry());
			sys.setMessage(sysDTO.getMessage());
			sys.setSunrise(sysDTO.getSunrise());
			sys.setSunset(sysDTO.getSunset());
			sys.setType(sysDTO.getType());

			City city = new City();
			city.setId(sysDTO.getIdCity());

			sys.setCity(city);

			return sys;
		}

		return null;
	}

}
