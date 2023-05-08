package com.iab.bootdrools.model;

public class GeometryChangeObject {
	
	private String id;

	private String percentageInView;
	
	private String type;

	public GeometryChangeObject(String percentageInView) {
		super();
		this.percentageInView = percentageInView;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPercentageInView() {
		return percentageInView;
	}

	public void setPercentageInView(String percentageInView) {
		this.percentageInView = percentageInView;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
