package com.java.namle.weatherAPI.modelDTO;

public class CloudsDTO extends CreatedDateDTO {
	private static final long serialVersionUID = 1L;
	private Long id ;
	private Long all;
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
	
	

}
