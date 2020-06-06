package com.teste.conversorgraus.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.conversorgraus.models.ConvertValues;
import com.teste.conversorgraus.services.ConverterService;
import com.teste.conversorgraus.services.HistoricService;

@RestController
@RequestMapping(value = "/api/converter")
public class ConverterController {
	
	@Autowired
	ConverterService converterService;
	
	@Autowired
	HistoricService historicService;

	@PostMapping()
	public ResponseEntity<HashMap<String, String>> toConverter(@RequestBody @Valid ConvertValues convertValues) {

			String convertedValue = converterService.convertTemperature(convertValues);
			
			historicService.saveHistoric(convertValues, convertedValue);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("convertedValue", convertedValue);

			return ResponseEntity.ok(map);

	}

}
