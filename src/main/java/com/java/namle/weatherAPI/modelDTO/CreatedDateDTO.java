package com.java.namle.weatherAPI.modelDTO;

import java.io.Serializable;
//

public abstract class CreatedDateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String createdDate;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	private Long idCity;
	public Long getIdCity() {
		return idCity;
	}
	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}
}
