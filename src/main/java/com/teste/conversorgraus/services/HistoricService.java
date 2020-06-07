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
	private HistoricRepository historicRepository;

	public void saveHistoric(ConvertValues convertValues, Float convertedValue) {
		Historic historic = fillHistoric(convertValues, convertedValue);

		historicRepository.save(historic);
	}

	public Historic fillHistoric(ConvertValues convertValues, Float convertedValue) {
		Historic historic = new Historic(new Date(), convertValues.getConvertedTo(), convertValues.getValueToConvert(),
				convertedValue);

		return historic;
	}

	public List<Historic> findAll() {
		return historicRepository.findAll();
	}

}
