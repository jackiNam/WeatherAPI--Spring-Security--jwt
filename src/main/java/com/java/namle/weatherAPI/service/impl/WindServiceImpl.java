package com.java.namle.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.WindDao;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.WindDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Wind;
import com.java.namle.weatherAPI.service.WindService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class WindServiceImpl implements WindService {

	@Autowired
	WindDao windDao;

	@Override
	public void add(WindDTO windDTO) {
		Wind wind = convertToEntity(windDTO);
		windDao.add(wind);

	}

	@Override
	public void update(WindDTO windDTO) {
		Wind wind = windDao.getById(windDTO.getId());
		if (wind != null) {

			wind = convertToEntity(windDTO);
			windDao.update(wind);

		}
	}

	@Override
	public void delete(Long id) {
		Wind wind = windDao.getById(id);
		if (wind != null) {

			windDao.delete(wind);

		}

	}

	@Override
	public WindDTO getById(Long id) {
		Wind wind = windDao.getById(id);
		if (wind != null) {
			WindDTO windDTO = convertToDTO(wind);

			return windDTO;
		}
		return null;
	}

	@Override
	public List<WindDTO> findWind(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public WindDTO convertToDTO(Wind wind) {
		WindDTO windDTO = new WindDTO();
		if (wind != null) {
			windDTO.setId(wind.getId());
			windDTO.setDeg(wind.getDeg());
			windDTO.setIdCity(wind.getCity().getId());
			windDTO.setSpeed(wind.getSpeed());
			windDTO.setCreatedDate(DateTimeUtils.formatDate(wind.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

			return windDTO;
		}

		return null;

	}

	public Wind convertToEntity(WindDTO windDTO) {
		Wind wind = new Wind();
		if (windDTO != null) {
			wind.setSpeed(windDTO.getSpeed());
			wind.setDeg(windDTO.getDeg());
			City city = new City();
			city.setId(windDTO.getIdCity());

			wind.setCity(city);

			return wind;
		}

		return null;
	}

}
