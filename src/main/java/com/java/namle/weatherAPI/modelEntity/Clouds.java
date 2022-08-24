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
@ApiModel(value = "Clouds model")
@Table(name = "clouds")
public class Clouds extends CreatedDate {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "_all")
	private Long all;

	@OneToOne
	@JoinColumn(name = "id_city")
	City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAll() {
		return all;
	}

	public void setAll(Long all) {
		this.all = all;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
