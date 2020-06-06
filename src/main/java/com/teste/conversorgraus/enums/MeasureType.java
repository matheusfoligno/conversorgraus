package com.teste.conversorgraus.enums;

public enum MeasureType {
	
	CELSIUS("Celsius"),
	FAHRENHEIT("Fahrenheit");
	
	private String name;
	
	private MeasureType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
