package com.java.namle.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.MainDao;
import com.java.namle.weatherAPI.modelDTO.MainDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Main;
import com.java.namle.weatherAPI.service.MainService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao mainDao;

	@Override
	public void add(MainDTO mainDTO) {

		Main main = convertToEntity(mainDTO);
		mainDao.add(main);
	}

	@Override
	public void update(MainDTO mainDTO) {
		Main main = mainDao.getById(mainDTO.getId());
		if (main != null) {
			main = convertToEntity(mainDTO);

			mainDao.update(main);

		}

	}

	@Override
	public void delete(Long id) {
		Main main = mainDao.getById(id);
		if (main != null) {

			mainDao.delete(main);

		}

	}

	@Override
	public MainDTO getById(Long id) {
		Main main = mainDao.getById(id);
		if (main != null) {
			MainDTO mainDTO = convertToDto(main);

			return mainDTO;
		}
		return null;
	}

	@Override
	public List<MainDTO> findMain(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	// convert to DTO

	public MainDTO convertToDto(Main main) {
		MainDTO mainDTO = new MainDTO();
		if (main != null) {
			mainDTO.setId(main.getId());
			mainDTO.setCreatedDate(DateTimeUtils.formatDate(main.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
			mainDTO.setFeels_like(main.getFeels_like());
			mainDTO.setHumidity(main.getHumidity());
			mainDTO.setIdCity(main.getCity().getId());
			mainDTO.setPressure(main.getPressure());
			mainDTO.setTemp(main.getTemp());
			mainDTO.setTemp_max(main.getTemp_max());
			mainDTO.setTemp_min(main.getTemp_min());
			return mainDTO;
		}

		return null;

	}

	public Main convertToEntity(MainDTO mainDTO) {
		Main main = new Main();
		if (mainDTO != null) {
			main.setFeels_like(mainDTO.getFeels_like());
			main.setHumidity(mainDTO.getHumidity());
			main.setPressure(mainDTO.getPressure());
			main.setTemp(mainDTO.getTemp());
			main.setTemp_max(mainDTO.getTemp_max());
			main.setTemp_min(mainDTO.getTemp_min());
			City city = new City();
			city.setId(mainDTO.getIdCity());
			main.setCity(city);

			return main;

		}

		return null;

	}

}
