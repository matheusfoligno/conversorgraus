package com.teste.conversorgraus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.services.HistoricService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value = "/api/historic")
@Api(value = "API REST histórico de converções")
public class HistoricController {

	@Autowired
	private HistoricService historicService;

	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Retorna uma lista de históricos de converções")
	public ResponseEntity<List<Historic>> findAllHistoric() {
		List<Historic> listHistoric = historicService.findAll();
		return ResponseEntity.ok().body(listHistoric);
	}

}
