package com.teste.conversorgraus.controllers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ConverterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void converterValidReturnStatus200() throws Exception {
		String convertValues = "{\"valueToConvert\": \"100\", \"convertedTo\" : \"CELSIUS\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/converter")
				.content(convertValues)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void converterValidReturnStatus200AndCorrectConvertedValue() throws Exception {
		String convertValues = "{\"valueToConvert\": \"5\", \"convertedTo\" : \"celsius\"}";
		
		String json = mockMvc.perform(MockMvcRequestBuilders.post("/api/converter")
				.content(convertValues)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.convertedValue").value("-15.0"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(json);
	}
	
	@Test
	public void converterInvalidReturnNotValidException() throws Exception {
		String convertValues = "{\"convertedTo\" : \"celsius\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/converter")
				.content(convertValues)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));

	}
	
}
