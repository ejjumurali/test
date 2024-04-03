package com.visit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visit.dto.VisitDto;
import com.visit.service.VisitService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class VisitController {

	@Autowired
	private VisitService visitService;

	@PostMapping("/createVisit")
	public ResponseEntity<List<VisitDto>> createVisit(@Valid @RequestBody List<VisitDto> dto) {
		ResponseEntity<List<VisitDto>> savedDtos = visitService.create(dto);
		return savedDtos;
	}

	@GetMapping("/getVisits")
	public ResponseEntity<List<VisitDto>> getAllVisits() {
		return visitService.getAll();
	}

	@GetMapping("/getVisitById")
	public ResponseEntity<VisitDto> getVisit(@RequestParam @NotEmpty(message = "id is required") Integer id) {
		return visitService.getById(id);
	}

	@PutMapping("/updateVisit")
	public ResponseEntity<VisitDto> createVisit(@Valid  @RequestBody VisitDto dto) {
		ResponseEntity<VisitDto> savedDtos = visitService.update(dto);
		return savedDtos;
	}
}
