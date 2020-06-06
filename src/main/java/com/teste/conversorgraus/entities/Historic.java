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
	private Date date;

	@Enumerated(EnumType.STRING)
	@Column(name = "convertedto")
	private MeasureType convertedTo;

	@Column(name = "valuetoconvert")
	private Float valueToConvert;

	@Column(name = "convertedvalue")
	private String convertedValue;

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

	public String getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(String convertedValue) {
		this.convertedValue = convertedValue;
	}

}
