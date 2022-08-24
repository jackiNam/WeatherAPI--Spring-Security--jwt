package com.java.namle.weatherAPI.modelDTO;

public class SearchDTO extends SearchSuper {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	private String fromDate;
	private String toDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public SearchDTO() {
		super();
	}
	
}
