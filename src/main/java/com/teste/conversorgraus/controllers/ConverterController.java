package com.teste.conversorgraus.controllers;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.conversorgraus.models.ConvertValues;
import com.teste.conversorgraus.services.ConverterService;
import com.teste.conversorgraus.services.HistoricService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/api/converter")
@Api(value = "API REST converção de graus")
public class ConverterController {
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private HistoricService historicService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Retorna o valor convertido")
	public ResponseEntity<HashMap<String, String>> toConverter(@RequestBody @Valid ConvertValues convertValues) {

			Float convertedValue = converterService.convertTemperature(convertValues);
			
			historicService.saveHistoric(convertValues, convertedValue);
			
			HashMap<String, String> map = new HashMap<>();
			map.put("convertedValue", convertedValue.toString());

			return ResponseEntity.ok().body(map);

	}

}
