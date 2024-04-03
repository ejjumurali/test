package com.patient.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.patient.dao.PatientDao;
import com.patient.dto.PatientDto;
import com.patient.entity.Patient;
import com.patient.mapper.PatientMapper;

class PatientServiceTest {

	@Mock
	PatientDao dao;
	@Mock
	PatientMapper patientMapper;

	@InjectMocks
	PatientService patientService;
	
	Patient patient= new Patient();
	PatientDto dto= new PatientDto();
	List<Patient> patlist = new ArrayList();
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		setTestData();
	}

	private void setTestData() {
		patient.setId(1);
		patient.setDateOfBirth("1990-11-11");
		patient.setName("John");
		patient.setSurName("King");
		patient.setSsn("zzzffgf122");
		patlist.add(patient);
		dto.setId(1);
		dto.setDateOfBirth("1990-11-11");
		dto.setName("John");
		dto.setSurName("King");
		dto.setSsn("zzzffgf122");
	}

	@Test
	@DisplayName("Create Patient")
	void createPatient() {
		Mockito.when(dao.create(Mockito.any())).thenReturn(patient);
		Mockito.when(patientMapper.convertToEntity(Mockito.any())).thenReturn(patient);
		Mockito.when(patientMapper.convertToDto(patient)).thenReturn(dto);
		ResponseEntity<PatientDto> responseEntity = patientService.create(dto);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	@Test
	@DisplayName("Get All Patients")
	void getAllPatient() {
		Mockito.when(dao.getAllPatients()).thenReturn(Collections.singletonList(patient));
		Mockito.when(patientMapper.convertToEntity(Mockito.any())).thenReturn(patient);
		Mockito.when(patientMapper.convertToDto(patient)).thenReturn(dto);
		ResponseEntity<List<PatientDto>> responseEntity = patientService.getAll();
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
}
