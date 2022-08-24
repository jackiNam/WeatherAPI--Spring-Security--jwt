package com.java.namle.weatherAPI.modelDTO;

public class WeatherDTO extends CreatedDateDTO {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idWeather;
	private String main;
	private String description;
	private String icon;

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

}
