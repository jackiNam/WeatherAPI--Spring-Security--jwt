package com.java.namle.weatherAPI.modelDTO;

public class CoordDTO extends CreatedDateDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Double lon;
	private Double lat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

}
