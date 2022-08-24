package com.java.namle.weatherAPI.modelEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "city")
@ApiModel(value = "City model")
public class City extends CreatedDate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "idCity")
	private Long idCity;

	@Column(name = "name")
	private String name;

	@Column(name = " cod")
	private Long cod;

	@Column(name = "timezone")
	private Long timezone;

	@Column(name = "dt")
	private Long dt;

	@Column(name = "visibility")
	private Long visibility;

	@Column(name = "base")
	private String base;

	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Clouds clouds;

	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Coord coord;

	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Main main;

	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Sys sys;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Weather> weathers;

	@OneToOne(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Wind wind;

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

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

}
