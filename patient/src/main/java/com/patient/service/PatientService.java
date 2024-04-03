package com.patient.service;

import com.patient.dao.PatientDao;
import com.patient.dto.PatientDto;
import com.patient.entity.Patient;
import com.patient.exception.PatientErrorCode;
import com.patient.exception.PatientRunTimeException;
import com.patient.mapper.PatientMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * PatientService which handles  creating and getting information
 */
@Service
public class PatientService {

	@Autowired
	public PatientDao dao;

	@Autowired
	private PatientMapper patientMapper;
	
	/**
	 * create Patient 
	 * @return Patient saved info
	 * @param dto
	 */
	public ResponseEntity<PatientDto> create(@Valid @RequestBody PatientDto dto) {
		PatientDto convertToDto;
		try {
			Patient convertToEntity = patientMapper.convertToEntity(dto);
			Patient savedEntity = dao.create(convertToEntity);
			convertToDto = patientMapper.convertToDto(savedEntity);
		} catch (DataIntegrityViolationException e) {
			throw new PatientRunTimeException(PatientErrorCode.PT_001, PatientErrorCode.PT_001.getMessage());
		}
		return new ResponseEntity<>(convertToDto, HttpStatus.OK);
	}
	/**
	 * method will fetch list of all patients
	 * @return List of Patients
	 */
	public ResponseEntity<List<PatientDto>> getAll() {
		List<Patient> allPatients = dao.getAllPatients();
		List<PatientDto> patlist = patientMapper.convertToDto(allPatients);
		return new ResponseEntity<>(patlist, HttpStatus.OK);
	}
	/**
	 * method will fetch patient information using Id
	 * @return patient
	 *@param  id
	 */ 
	public ResponseEntity<PatientDto> getById(Integer id) {
		Patient patient = dao.findById(id);
		 PatientDto patientDto = patientMapper.convertToDto(patient);
		 return new ResponseEntity<>(patientDto, HttpStatus.OK);
	}

}
