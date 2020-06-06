package com.teste.conversorgraus.controllers;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.models.ConvertValues;
import com.teste.conversorgraus.repositories.HistoricRepository;
import com.teste.conversorgraus.services.ConverterService;
import com.teste.conversorgraus.services.HistoricService;

@RestController
@RequestMapping(value = "/api")
public class ConverterController {

	@Autowired
	HistoricRepository historicRepository;
	
	@Autowired
	ConverterService converterService;
	
	@Autowired
	HistoricService historicService;

	@PostMapping("/toConverter")
	public ResponseEntity<HashMap<String, String>> toConverter(@RequestBody @Valid ConvertValues convertValues) {

			String convertedValue = converterService.convertTemperature(convertValues);
			
			Historic historic = historicService.fillHistoric(convertValues, convertedValue);
			historicRepository.save(historic);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("convertedValue", convertedValue);

			return ResponseEntity.ok(map);

	}
	
	@GetMapping("/historic")
	public List<Historic> findAllHistoric(){
		return historicRepository.findAll();
	}

}
