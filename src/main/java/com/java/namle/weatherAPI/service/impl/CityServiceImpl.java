package com.java.namle.weatherAPI.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.namle.weatherAPI.dao.CityDao;
import com.java.namle.weatherAPI.modelDTO.CityDTO;
import com.java.namle.weatherAPI.modelDTO.CloudsDTO;
import com.java.namle.weatherAPI.modelDTO.CoordDTO;
import com.java.namle.weatherAPI.modelDTO.MainDTO;
import com.java.namle.weatherAPI.modelDTO.SearchDTO;
import com.java.namle.weatherAPI.modelDTO.SysDTO;
import com.java.namle.weatherAPI.modelDTO.WeatherDTO;
import com.java.namle.weatherAPI.modelDTO.WindDTO;
import com.java.namle.weatherAPI.modelEntity.City;
import com.java.namle.weatherAPI.modelEntity.Clouds;
import com.java.namle.weatherAPI.modelEntity.Coord;
import com.java.namle.weatherAPI.modelEntity.Main;
import com.java.namle.weatherAPI.modelEntity.Sys;
import com.java.namle.weatherAPI.modelEntity.Weather;
import com.java.namle.weatherAPI.modelEntity.Wind;
import com.java.namle.weatherAPI.service.CityService;
import com.java.namle.weatherAPI.utils.DateTimeUtils;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao cityDao;

	@Override
	public void add(CityDTO cityDTO) {
		City city = convertToEntity(cityDTO);
		cityDao.add(city);

	}

	@Override
	public void update(CityDTO cityDTO) {
		City city = convertToEntity(cityDTO);
		city.setId(cityDTO.getId());

		// set id clouds
		Clouds clouds = city.getClouds();
		clouds.setCreatedDate(new Date());
		clouds.setId(cityDTO.getClouds().getId());

		// set id coord
		Coord coord = city.getCoord();
		coord.setCreatedDate(new Date());
		coord.setId(cityDTO.getCoord().getId());

		// set id Main
		Main main = city.getMain();
		main.setCreatedDate(new Date());
		main.setId(cityDTO.getMain().getId());

		// set id Sys
		Sys sys = city.getSys();
		sys.setCreatedDate(new Date());
		sys.setId(cityDTO.getSys().getIdSys());

		// set id Weather
		List<Weather> weathers = new ArrayList<Weather>();
		List<WeatherDTO> weatherDTOs = cityDTO.getWeather();
		for (WeatherDTO weatherDTO : weatherDTOs) {
			Weather weather = new Weather();
			weather.setId(weatherDTO.getId());
			weather.setCreatedDate(new Date());
			weather.setCity(city);
			weather.setDescription(weatherDTO.getDescription());
			weather.setIcon(weatherDTO.getIcon());
			weather.setMain(weatherDTO.getMain());
			weather.setIdWeather(weatherDTO.getId());
			weathers.add(weather);

		}

		// set id wind
		Wind wind = city.getWind();
		wind.setCreatedDate(new Date());
		wind.setId(cityDTO.getWind().getId());

		city.setId(cityDTO.getId());
		city.setCreatedDate(new Date());
		city.setIdCity(cityDTO.getIdCity());
		System.out.println(city.getSys().getSunrise() + "test sunrise sys in model city ham update");

		city.setClouds(clouds);
		city.setCoord(coord);
		city.setMain(main);
		city.setSys(sys);
		city.setWind(wind);
		city.setWeathers(weathers);

		cityDao.update(city);

	}

	@Override
	public void delete(Long id) {
		City city = cityDao.getById(id);
		if (city != null) {

			cityDao.delete(city);

		}

	}

	@Override
	public CityDTO getById(Long id) {
		City city = cityDao.getById(id);
		if (city != null) {
			CityDTO cityDTO = convertToDTO(city);
			return cityDTO;
		}
		return null;
	}

	@Override
	public List<CityDTO> findCity(SearchDTO searchDTO) {
		List<City> citys = cityDao.findCity(searchDTO);

		if (citys != null) {
			List<CityDTO> cityDTOs = new ArrayList<CityDTO>();

			citys.forEach(City -> {
				cityDTOs.add(convertToDTO(City));

			});

			return cityDTOs;
		}
		return null;
	}

	// convert to Entity
	public City convertToEntity(CityDTO cityDTO) {
		City city = new City();
		city.setIdCity(cityDTO.getId());

		city.setBase(cityDTO.getBase());
		city.setCod(cityDTO.getCod());
		city.setName(cityDTO.getName());
		city.setDt(cityDTO.getDt());
		city.setTimezone(cityDTO.getTimezone());
		city.setVisibility(cityDTO.getVisibility());
		// clouds
		CloudsDTO cloudDTO = cityDTO.getClouds();
		Clouds clouds = new Clouds();

		clouds.setAll(cloudDTO.getAll());
		clouds.setCity(city);

		city.setClouds(clouds);

		// coord

		CoordDTO coordDTO = cityDTO.getCoord();

		Coord coord = new Coord();

		coord.setLat(coordDTO.getLat());
		coord.setLon(coordDTO.getLon());
		coord.setCity(city);

		city.setCoord(coord);

		// main

		MainDTO mainDTO = cityDTO.getMain();

		Main main = new Main();
		main.setCity(city);
		main.setFeels_like(mainDTO.getFeels_like());
		main.setHumidity(mainDTO.getHumidity());
		main.setPressure(mainDTO.getPressure());
		main.setTemp(mainDTO.getTemp());
		main.setTemp_max(mainDTO.getTemp_max());
		main.setTemp_min(mainDTO.getTemp_min());

		city.setMain(main);

		// Sys

		SysDTO sysDTO = cityDTO.getSys();

		// test

		Sys sys = new Sys();
		sys.setIdSys(sysDTO.getId());
		sys.setCity(city);
		sys.setCountry(sysDTO.getCountry());
		sys.setMessage(sysDTO.getMessage());
		sys.setSunrise(sysDTO.getSunrise());
		sys.setSunset(sysDTO.getSunset());
		sys.setType(sysDTO.getType());

		city.setSys(sys);

		// Weather

		List<Weather> weathers = new ArrayList<Weather>();
		List<WeatherDTO> weatherDTOs = cityDTO.getWeather();
		for (WeatherDTO weatherDTO : weatherDTOs) {
			Weather weather = new Weather();
			weather.setCity(city);
			weather.setDescription(weatherDTO.getDescription());
			weather.setIcon(weatherDTO.getIcon());
			weather.setMain(weatherDTO.getMain());
			weather.setIdWeather(weatherDTO.getId());

			weathers.add(weather);

		}
		city.setWeathers(weathers);

		// Wind

		WindDTO windDTO = cityDTO.getWind();

		Wind wind = new Wind();
		wind.setCity(city);
		wind.setDeg(windDTO.getDeg());
		wind.setSpeed(windDTO.getSpeed());

		city.setWind(wind);

		return city;
	}

	public CityDTO convertToDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		cityDTO.setBase(city.getBase());
		cityDTO.setCod(city.getCod());
		cityDTO.setDt(city.getDt());
		cityDTO.setId(city.getId());
		cityDTO.setIdCity(city.getIdCity());
		cityDTO.setName(city.getName());
		cityDTO.setTimezone(city.getTimezone());
		cityDTO.setVisibility(city.getVisibility());
		cityDTO.setCreatedDate(DateTimeUtils.formatDate(city.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
		// clouds
		CloudsDTO cloudsDTO = new CloudsDTO();
		Clouds clouds = city.getClouds();
		cloudsDTO.setAll(clouds.getAll());
		cloudsDTO.setIdCity(clouds.getCity().getIdCity());
		cloudsDTO.setId(clouds.getId());
		cloudsDTO.setCreatedDate(DateTimeUtils.formatDate(clouds.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

		cityDTO.setClouds(cloudsDTO);

		// Coord

		CoordDTO coordDTO = new CoordDTO();
		Coord coord = city.getCoord();
		coordDTO.setId(coord.getId());
		coordDTO.setIdCity(coord.getCity().getIdCity());
		coordDTO.setLat(coord.getLat());
		coordDTO.setLon(coord.getLon());
		coordDTO.setCreatedDate(DateTimeUtils.formatDate(coord.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

		cityDTO.setCoord(coordDTO);
		// Main
		MainDTO mainDTO = new MainDTO();
		Main main = city.getMain();
		mainDTO.setId(main.getId());
		mainDTO.setFeels_like(main.getFeels_like());
		mainDTO.setHumidity(main.getHumidity());
		mainDTO.setIdCity(main.getCity().getIdCity());
		mainDTO.setPressure(main.getPressure());
		mainDTO.setTemp(main.getTemp());
		mainDTO.setTemp_max(main.getTemp_max());
		mainDTO.setTemp_min(main.getTemp_min());
		mainDTO.setCreatedDate(DateTimeUtils.formatDate(main.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

		cityDTO.setMain(mainDTO);

		// Sys
		SysDTO sysDTO = new SysDTO();
		Sys sys = city.getSys();
		sysDTO.setId(sys.getIdSys());
		sysDTO.setIdSys(sys.getId());
		sysDTO.setCountry(sys.getCountry());
		sysDTO.setIdCity(sys.getCity().getIdCity());
		sysDTO.setMessage(sys.getMessage());
		sysDTO.setSunrise(sys.getSunrise());
		sysDTO.setSunset(sys.getSunset());
		sysDTO.setType(sys.getType());
		sysDTO.setCreatedDate(DateTimeUtils.formatDate(sys.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));

		cityDTO.setSys(sysDTO);

		// Weather
		List<WeatherDTO> weatherDTOs = new ArrayList<WeatherDTO>();
		List<Weather> weathers = city.getWeathers();
		for (Weather weather : weathers) {

			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setId(weather.getId());
			weatherDTO.setIdWeather(weather.getIdWeather());
			weatherDTO.setDescription(weather.getDescription());
			weatherDTO.setIcon(weather.getIcon());
			weatherDTO.setIdCity(weather.getCity().getIdCity());
			weatherDTO
					.setCreatedDate(DateTimeUtils.formatDate(weather.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
			weatherDTO.setMain(weather.getMain());
			weatherDTOs.add(weatherDTO);
		}
		cityDTO.setWeather(weatherDTOs);

		// Wind
		WindDTO windDTO = new WindDTO();
		Wind wind = city.getWind();

		windDTO.setId(wind.getId());
		windDTO.setDeg(wind.getDeg());
		windDTO.setIdCity(wind.getCity().getIdCity());
		windDTO.setSpeed(wind.getSpeed());
		windDTO.setCreatedDate(DateTimeUtils.formatDate(wind.getCreatedDate(), DateTimeUtils.DD_MM_YYYY_HH_MM));
		cityDTO.setWind(windDTO);

		return cityDTO;

	}

}
