package com.teste.conversorgraus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping()
	public List<Historic> findAllHistoric() {
		return historicService.findAll();
	}

}
