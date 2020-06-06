package com.teste.conversorgraus.models;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.teste.conversorgraus.enums.MeasureType;

public class ConvertValues {

	@NotNull(message = "{valueToConvert.not.null}")
	private Float valueToConvert;

	@NotNull(message = "{convertedTo.not.null}")
	@Enumerated(EnumType.STRING)
	private MeasureType convertedTo;
	
	public ConvertValues() {
	}

	public Float getValueToConvert() {
		return valueToConvert;
	}

	public void setValueToConvert(Float valueToConvert) {
		this.valueToConvert = valueToConvert;
	}

	public MeasureType getConvertedTo() {
		return convertedTo;
	}

	public void setConvertedTo(MeasureType convertedTo) {
		this.convertedTo = convertedTo;
	}

}
