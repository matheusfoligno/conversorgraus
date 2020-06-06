package com.teste.conversorgraus.services;

import org.springframework.stereotype.Service;

import com.teste.conversorgraus.models.ConvertValues;

@Service
public class ConverterService {
	
	public String convertTemperature(ConvertValues convertValues) {
		Float value = null;
		switch(convertValues.getConvertedTo().getName()) {
			case "Celsius":
				value = ((convertValues.getValueToConvert() - 32)*5)/9;
				return value + " °C";
			default:
				value = (convertValues.getValueToConvert() * 9/5) + 32;
				return value + " °F";
		}
	}

}
