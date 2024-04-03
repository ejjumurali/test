package com.visit.controller;

import static org.junit.jupiter.api.Assertions.fail;
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

import com.visit.dto.VisitDto;
import com.visit.entity.Visit;
import com.visit.service.VisitService;

@SpringBootTest(classes = { VisitController.class })
@AutoConfigureMockMvc
class VisitControllerTest {

	@InjectMocks
	VisitController visitController;

	@MockBean
	VisitService visitService;

	@Autowired
	MockMvc mockMvc;
	ResponseEntity<List<VisitDto>> response;

	Visit visit = new Visit();
	VisitDto dto = new VisitDto();
	List<Visit> visitList = new ArrayList<Visit>();

	void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
		setTestData();
		when(visitService.getAll()).thenReturn(response);
	}

	@BeforeEach
	private void setTestData() {
		visit.setId(1);
		visit.setDate("1990-11-11");
		visit.setTime("11:23");
		visit.setFamilyHistory("history");
		visit.setVisitType("Home");
		visit.setVisitReason("Doctyor");
		dto.setId(1);
		dto.setDate("1990-11-11");
		dto.setTime("11:23");
		dto.setFamilyHistory("history");
		dto.setVisitType("Home");
		dto.setVisitReason("Doctyor");
		response = new ResponseEntity(visitList, HttpStatus.OK);
	}

	@Test
	@DisplayName("Get Visits Test")
	public void getPatientsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getVisits")).andExpect(MockMvcResultMatchers.status().isOk());
		verify(visitService, atMostOnce()).getAll();
	}

}
