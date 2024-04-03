package com.visit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.visit.dao.VisitDao;
import com.visit.dto.VisitDto;
import com.visit.entity.Visit;
import com.visit.mapper.VisitMapper;

class visitServiceTest {
	@Mock
	VisitDao dao;

	@Mock
	VisitMapper visitMapper;

	@InjectMocks
	VisitService service;

	Visit visit = new Visit();
	VisitDto dto = new VisitDto();
	List<Visit> visitList = new ArrayList();
	List<VisitDto> visitDtoList = new ArrayList();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		setTestData();
	}

	private void setTestData() {
		visit.setId(1);
		visit.setDate("1990-11-11");
		visit.setTime("11:23");
		visit.setFamilyHistory("history");
		visit.setVisitType("Home");
		visit.setVisitReason("Doctyor");
		visitList.add(visit);
		dto.setDate("1990-11-11");
		dto.setTime("11:23");
		dto.setFamilyHistory("history");
		dto.setVisitType("Home");
		dto.setVisitReason("Doctyor");
		visitDtoList.add(dto);
	}

	@Test
	@DisplayName("Create Visit")
	void createVisit() {
		Mockito.when(dao.create(Mockito.any())).thenReturn(visitList);
		Mockito.when(visitMapper.convertToEntity(Mockito.any())).thenReturn(Collections.singletonList(visit));
		Mockito.when(visitMapper.convertToDto(visit)).thenReturn(dto);
		ResponseEntity<List<VisitDto>> responseEntity = service.create(visitDtoList);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
	}

	@Test
	@DisplayName("Get All Visit")
	void getAllVisits() {
		Mockito.when(dao.getAllVisits()).thenReturn(Collections.singletonList(visit));
		Mockito.when(visitMapper.convertToEntity(Mockito.any())).thenReturn(Collections.singletonList(visit));
		Mockito.when(visitMapper.convertToDto(Mockito.anyList())).thenReturn(visitDtoList);
		ResponseEntity<List<VisitDto>> responseEntity = service.getAll();
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}

}
