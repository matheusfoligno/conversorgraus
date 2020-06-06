package com.teste.conversorgraus.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.models.ConvertValues;
import com.teste.conversorgraus.repositories.HistoricRepository;

@Service
public class HistoricService {
	
	@Autowired
	HistoricRepository historicRepository;
	
	public void saveHistoric(ConvertValues convertValues, String convertedValue) {
		Historic historic = fillHistoric(convertValues, convertedValue);
		
		historicRepository.save(historic);
	}
	
	public Historic fillHistoric(ConvertValues convertValues, String convertedValue) {
		Historic historic = new Historic();
		
		historic.setValueToConvert(convertValues.getValueToConvert());
		historic.setConvertedTo(convertValues.getConvertedTo());
		historic.setConvertedValue(convertedValue);
		historic.setDate(new Date());
		
		return historic;
	}
	
	public List<Historic> findAll() {
		return historicRepository.findAll();
	}

}
