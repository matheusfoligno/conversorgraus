package com.teste.conversorgraus.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.models.ConvertValues;

@Service
public class HistoricService {
	
	public Historic fillHistoric(ConvertValues convertValues, String convertedValue) {
		Historic historic = new Historic();
		
		historic.setValueToConvert(convertValues.getValueToConvert());
		historic.setConvertedTo(convertValues.getConvertedTo());
		historic.setConvertedValue(convertedValue);
		historic.setDate(new Date());
		
		return historic;
	}

}
