package com.java.namle.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.CityDao;
import com.java.namle.weatherAPI.dao.CloudsDao;
import com.java.namle.weatherAPI.modelDTO.CloudsDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Clouds;
import com.java.namle.weatherAPI.service.CloudsService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class CloudsServiceImpl implements CloudsService {

	@Autowired
	CloudsDao cloudsDao;

	
	@Autowired
	CityDao cityDao;
	
	//add
	@Override
	public void add(CloudsDTO cloudsDTO) {
		Clouds clouds = corvertToEntity(cloudsDTO);
		cloudsDao.add(clouds);

	}

	
	//update
	@Override
	public void update(CloudsDTO cloudsDTO) {
		City city = cityDao.getById(cloudsDTO.getIdCity());
		System.out.println(cloudsDTO.getIdCity() + "test clouds");
		if (city != null) {

		Clouds	clouds = corvertToEntity(cloudsDTO);

			cloudsDao.update(clouds);

		}

	}

	
	//delete
	@Override
	public void delete(Long id) {
		Clouds clouds = cloudsDao.getById(id);
		if (clouds != null) {

			cloudsDao.delete(clouds);
		}

	}

	
	//getById
	@Override
	public CloudsDTO getById(Long id) {
		Clouds clouds = cloudsDao.getById(id);
		if (clouds != null) {
			CloudsDTO cloudsDTO = covertToDTO(clouds);

			return cloudsDTO;

		}
		return null;
	}

	
	//find
	@Override
	public List<CloudsDTO> findClouds(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	// covert doi tuong entity sang DTO
	public CloudsDTO covertToDTO(Clouds clouds) {
		CloudsDTO cloudsDTO = new CloudsDTO();
		if (clouds != null) {
			cloudsDTO.setAll(clouds.getAll());
			cloudsDTO.setId(clouds.getId());
			cloudsDTO.setIdCity(clouds.getCity().getIdCity());
			cloudsDTO.setCreatedDate(DateTimeUtils.formatDate(clouds.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

			return cloudsDTO;
		} else {
			return null;
		}

	}

	// covert doi tuong DTO sang entity
	public Clouds corvertToEntity(CloudsDTO cloudsDTO) {
		Clouds clouds = new Clouds();
		if (cloudsDTO != null) {
			clouds.setAll(cloudsDTO.getAll());

			City city = new City();
			city.setId(cloudsDTO.getIdCity());

			clouds.setCity(city);

			return clouds;
		}

		return null;
	}

}
