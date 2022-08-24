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
@Table(name="main")
@ApiModel(value = "Main model")
@DynamicUpdate
public class Main extends CreatedDate{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="temp")
	private Double temp;
	
	@Column(name="feels_like")
	private Double feels_like;
	
	@Column(name="temp_max")
	private Double temp_max;
	
	@Column(name="temp_min")
	private Double temp_min;
	
	@Column(name="pressure")
	private Long pressure;
	
	@Column(name="humidity")
	private Long humidity;
	
	@OneToOne
	@JoinColumn(name = "id_city")
	 City city;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(Double feels_like) {
		this.feels_like = feels_like;
	}

	public Double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}

	public Double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}

	public Long getPressure() {
		return pressure;
	}

	public void setPressure(Long pressure) {
		this.pressure = pressure;
	}

	public Long getHumidity() {
		return humidity;
	}

	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


}
