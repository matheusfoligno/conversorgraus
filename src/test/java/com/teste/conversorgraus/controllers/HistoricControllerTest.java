package com.teste.conversorgraus.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.enums.MeasureType;
import com.teste.conversorgraus.repositories.HistoricRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HistoricControllerTest {

	@MockBean
	private HistoricRepository historicRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listHistoricCorrectShouldReturnStatus200() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/historic").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void listHistoricWhenConvertedToAreCorrectShouldReturnStatus200() throws Exception {
		Historic historic = new Historic(new Date(), MeasureType.CELSIUS, 10.0f, 1.0f);

		List<Historic> allHistoric = Arrays.asList(historic);

		when(historicRepository.findAll()).thenReturn(allHistoric);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/historic")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].convertedTo").value(historic.getConvertedTo().toString()));
	}

}
