package com.teste.conversorgraus.repositories;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.teste.conversorgraus.entities.Historic;
import com.teste.conversorgraus.enums.MeasureType;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource({ "classpath:application-test.properties" })
public class HistoricRepositoryTest {

	@Autowired
	private HistoricRepository historicRepository;
	
	private static Validator validator;
	
	@BeforeClass
	public static void setupValidatorInstance() {
	    validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void whenCreateHistoricFilledThenReturnsSuccess() {
		Historic historic = new Historic(new Date(), MeasureType.CELSIUS, 10.0f, 1.0f);

		historicRepository.save(historic);

		Assertions.assertThat(historic.getId()).isNotNull();
		Assertions.assertThat(historic.getDate()).isNotNull();
		Assertions.assertThat(historic.getConvertedTo()).isEqualTo(MeasureType.CELSIUS);
		Assertions.assertThat(historic.getValueToConvert()).isEqualTo(10.0f);
		Assertions.assertThat(historic.getConvertedValue()).isEqualTo(1.0f);

	}
	
	@Test
	public void whenNotNullConvertedToThenNoConstraintViolation() {
		Historic historic = new Historic(new Date(), MeasureType.FAHRENHEIT, 10.0f, 1.0f);

		Set<ConstraintViolation<Historic>> violations = validator.validate(historic);
		
		Assertions.assertThat(violations.size()).isEqualTo(0);
	}

	@Test
	public void whenNullConvertedToThenOneConstraintViolation() {
		Historic historic = new Historic(new Date(), null, 10.0f, 1.0f);

		Set<ConstraintViolation<Historic>> violations = validator.validate(historic);
		
		Assertions.assertThat(violations.size()).isEqualTo(1);
	}
}
