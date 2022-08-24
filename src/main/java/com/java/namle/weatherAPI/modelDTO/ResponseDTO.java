package com.java.namle.weatherAPI.modelDTO;
import java.io.Serializable;
import java.util.List;

public class ResponseDTO<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<T> data;
	
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	
}
