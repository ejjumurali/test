package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dto.PatientDto;
import com.patient.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/createPatient")
	public  ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto dto) {
		return patientService.create(dto);
	}
	@GetMapping("/getAllPatients")
	public  ResponseEntity<List<PatientDto>> getAllPatients() {
		return patientService.getAll();
	}
	@GetMapping("/getPatient")
	public  ResponseEntity<PatientDto> getPatient(@RequestParam @NotEmpty(message ="id is required") Integer id) {
		return patientService.getById(id);
	}
}
