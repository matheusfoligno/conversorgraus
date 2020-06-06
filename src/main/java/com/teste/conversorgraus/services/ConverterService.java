package com.teste.conversorgraus.services;

import org.springframework.stereotype.Service;

import com.teste.conversorgraus.models.ConvertValues;

@Service
public class ConverterService {

	public Float convertTemperature(ConvertValues convertValues) {
		switch (convertValues.getConvertedTo().getName()) {
			case "Celsius":
				return ((convertValues.getValueToConvert() - 32) * 5) / 9;
			default:
				return (convertValues.getValueToConvert() * 9 / 5) + 32;
		}
	}

}
