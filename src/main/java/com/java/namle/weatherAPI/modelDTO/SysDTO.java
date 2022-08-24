package com.java.namle.weatherAPI.modelDTO;

public class SysDTO extends CreatedDateDTO {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idSys;
	private Long type;
	private Double message;
	private String country;
	private Long sunrise;
	private Long sunset;

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

}
