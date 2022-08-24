package com.java.namle.weatherAPI.modelDTO;

public class WindDTO extends CreatedDateDTO {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Double speed;
	private Long deg;

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
