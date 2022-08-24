package com.java.namle.weatherAPI.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "weather")
@ApiModel(value = "Weather model")
public class Weather extends CreatedDate {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = " id_Weather")
	private Long idWeather;
	
	@Column(name = " main")
	private String main;

	@Column(name = "description")
	private String description;

	@Column(name = "icon")
	private String icon;

	@ManyToOne
	@JoinColumn(name = "id_city")
	City city;

	
	public Long getIdWeather() {
		return idWeather;
	}

	public void setIdWeather(Long idWeather) {
		this.idWeather = idWeather;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
