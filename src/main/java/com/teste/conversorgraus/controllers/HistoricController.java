package com.teste.conversorgraus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.services.HistoricService;

@RestController
@RequestMapping(value = "/api/historic")
public class HistoricController {

	@Autowired
	HistoricService historicService;

	@GetMapping(produces = "application/json; charset=utf-8")
	public ResponseEntity<List<Historic>> findAllHistoric() {
		List<Historic> listHistoric = historicService.findAll();
		return ResponseEntity.ok().body(listHistoric);
	}

}
