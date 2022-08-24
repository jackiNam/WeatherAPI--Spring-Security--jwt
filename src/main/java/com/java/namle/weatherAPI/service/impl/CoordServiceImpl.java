package com.java.namle.weatherAPI.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.CoordDao;
import com.java.namle.weatherAPI.modelDTO.CoordDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Coord;
import com.java.namle.weatherAPI.service.CoordService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class CoordServiceImpl implements CoordService {

	@Autowired
	CoordDao coordDao;

	@Override
	public void add(CoordDTO coordDTO) {

		Coord coord = convertToEntity(coordDTO);

		coordDao.add(coord);

	}

	@Override
	public void update(CoordDTO coordDTO) {
		Coord coord = coordDao.getById(coordDTO.getId());
		if(coord!=null) {
			coord= convertToEntity(coordDTO);
			
			coordDao.update(coord);
			
		}

	}

	@Override
	public void delete(Long id) {
		Coord coord = coordDao.getById(id);
		if(coord!=null) {
			
			coordDao.delete(coord);
			
		}

	}

	@Override
	public CoordDTO getById(Long id) {
		Coord coord = coordDao.getById(id);
		if(coord!=null) {
			
			CoordDTO coordDTO = convertToDTO(coord);
			
			return coordDTO;
		}
		return null;
	}

	@Override
	public List<CoordDTO> findCoord(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	// corvert doi tuong DTO sang Entity
	public Coord convertToEntity(CoordDTO coordDTO) {

		Coord coord = new Coord();
		if (coordDTO != null) {
			coord.setLat(coordDTO.getLat());
			coord.setLon(coordDTO.getLat());

			City city = new City();
			city.setId(coordDTO.getIdCity());

			coord.setCity(city);

			return coord;
		}

		return null;

	}

	// convert doi tuong entity sang DTO
	public CoordDTO convertToDTO(Coord coord) {
		CoordDTO coordDTO = new CoordDTO();
		if (coord != null) {

			coordDTO.setId(coord.getId());
			coordDTO.setIdCity(coord.getCity().getId());
			coordDTO.setLat(coord.getLat());
			coordDTO.setLon(coord.getLon());
			coordDTO.setCreatedDate(DateTimeUtils.formatDate(coord.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

			return coordDTO;
		}

		return null;
	}

}
