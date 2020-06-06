package com.teste.conversorgraus.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.teste.conversorgraus.enums.MeasureType;

@Entity
@Table(name = "HISTORIC")
public class Historic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	@NotNull(message = "{date.not.null}")
	private Date date;

	@Enumerated(EnumType.STRING)
	@Column(name = "convertedto")
	@NotNull(message = "{convertedTo.not.null}")
	private MeasureType convertedTo;

	@Column(name = "valuetoconvert")
	@NotNull(message = "{valueToConvert.not.null}")
	private Float valueToConvert;

	@Column(name = "convertedvalue")
	@NotNull(message = "{convertedValue.not.null}")
	private Float convertedValue;
	
	public Historic() {
	}

	public Historic(Date date, MeasureType convertedTo, Float valueToConvert, Float convertedValue) {
		super();
		this.date = date;
		this.convertedTo = convertedTo;
		this.valueToConvert = valueToConvert;
		this.convertedValue = convertedValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MeasureType getConvertedTo() {
		return convertedTo;
	}

	public void setConvertedTo(MeasureType convertedTo) {
		this.convertedTo = convertedTo;
	}

	public Float getValueToConvert() {
		return valueToConvert;
	}

	public void setValueToConvert(Float valueToConvert) {
		this.valueToConvert = valueToConvert;
	}

	public Float getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Float convertedValue) {
		this.convertedValue = convertedValue;
	}

}
