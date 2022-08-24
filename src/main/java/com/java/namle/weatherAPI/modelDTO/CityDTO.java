package com.java.namle.weatherAPI.modelDTO;

import java.io.Serializable;
import java.util.List;

public class CityDTO extends CreatedDateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCity;
	private Long id;
	private String name;
	private Long cod;
	private Long timezone;
	private Long dt;
	private Long visibility;
	private String base;
	private CloudsDTO clouds;
	private CoordDTO coord;
	private MainDTO main;
	private SysDTO sys;
	private List<WeatherDTO> weather;
	private WindDTO wind;



	public Long getIdCity() {
		return idCity;
	}

	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCod() {
		return cod;
	}

	public void setCod(Long cod) {
		this.cod = cod;
	}

	public Long getTimezone() {
		return timezone;
	}

	public void setTimezone(Long timezone) {
		this.timezone = timezone;
	}

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public Long getVisibility() {
		return visibility;
	}

	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public List<WeatherDTO> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDTO> weather) {
		this.weather = weather;
	}

	public CloudsDTO getClouds() {
		return clouds;
	}

	public void setClouds(CloudsDTO clouds) {
		this.clouds = clouds;
	}

	public CoordDTO getCoord() {
		return coord;
	}

	public void setCoord(CoordDTO coord) {
		this.coord = coord;
	}

	public MainDTO getMain() {
		return main;
	}

	public void setMain(MainDTO main) {
		this.main = main;
	}

	public SysDTO getSys() {
		return sys;
	}

	public void setSys(SysDTO sys) {
		this.sys = sys;
	}

	public WindDTO getWind() {
		return wind;
	}

	public void setWind(WindDTO wind) {
		this.wind = wind;
	}

}
