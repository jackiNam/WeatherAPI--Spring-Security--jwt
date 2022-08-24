package com.java.namle.weatherAPI.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="sys")
@DynamicUpdate
@ApiModel(value = "Sys model")
public class Sys extends CreatedDate {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_Sys")
	private Long idSys;
	
	
	@Column(name="type")
	private Long type;
	
	@Column(name="message")
	private Double message;
	
	@Column(name="country")
	private String country;
	
	@Column(name="sunrise")
	private Long sunrise;
	
	@Column(name="sunset")
	private Long sunset;
	
	@OneToOne
	@JoinColumn(name = "id_city")
	 City city;
	
	
	
	public Long getIdSys() {
		return idSys;
	}

	public void setIdSys(Long idSys) {
		this.idSys = idSys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Double getMessage() {
		return message;
	}

	public void setMessage(Double message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getSunrise() {
		return sunrise;
	}

	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}

	public Long getSunset() {
		return sunset;
	}

	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
}
