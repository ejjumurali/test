package com.patient.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.patient.dto.PatientDto;
import com.patient.entity.Patient;

@Mapper(componentModel = "spring")
public interface PatientMapper {

	Patient convertToEntity(PatientDto dto);

	PatientDto convertToDto(Patient patient);

	List<PatientDto> convertToDto(List<Patient> patient);
}
