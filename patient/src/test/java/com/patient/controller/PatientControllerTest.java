package com.patient.controller;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.patient.dto.PatientDto;
import com.patient.entity.Patient;
import com.patient.service.PatientService;

@SpringBootTest(classes = { PatientController.class })
@AutoConfigureMockMvc
class PatientControllerTest {

	@InjectMocks
	PatientController patientController;

	@MockBean
	PatientService patientService;

	@Autowired
	MockMvc mockMvc;

	ResponseEntity<List<PatientDto>> response;

	Patient patient = new Patient();
	PatientDto dto = new PatientDto();
	List<Patient> patientList= new ArrayList<Patient>();

	void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
		setTestData();
		when(patientService.getAll()).thenReturn(response);
	}

	@BeforeEach
    public void setTestData() {
		patient.setId(1);
		patient.setDateOfBirth("1990-11-11");
		patient.setName("John");
		patient.setSurName("King");
		patient.setSsn("zzzffgf122");
		dto.setDateOfBirth("1990-11-11");
		dto.setName("John");
		dto.setSurName("King");
		dto.setSsn("zzzffgf122");
		patientList.add(patient);
		response = new ResponseEntity(patientList, HttpStatus.OK);
	}

	@Test
	@DisplayName("Get Patients Test")
	public void getPatientsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllPatients")).andExpect(MockMvcResultMatchers.status().isOk());
		verify(patientService, atMostOnce()).getAll();
	}
}
