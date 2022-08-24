package com.java.namle.weatherAPI.modelEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="wind")
@ApiModel(value = "Wind model")
public class Wind extends CreatedDate{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="speed")
	private Double speed;
	
	@Column(name="deg")
	private Long deg;
	
	@OneToOne
	@JoinColumn(name = "id_city")
	 City city;
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Long getDeg() {
		return deg;
	}

	public void setDeg(Long deg) {
		this.deg = deg;
	}

	
	

}
