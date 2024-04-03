package com.patient.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;

@Validated
public class PatientDto {

	private Integer id;
	
	@NotNull(message = "name is mandatory")
	private String name;
	
	@NotNull(message = "surName is mandatory")
	private String surName;
	@NotNull(message = "Date of birth is mandatory")
	private String dateOfBirth;
	
	@NotNull(message = "Social Security number  is mandatory")
	private String ssn;

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getSsn() {
		return ssn;
	}


}
