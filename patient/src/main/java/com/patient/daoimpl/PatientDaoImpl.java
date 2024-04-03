package com.patient.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.patient.dao.PatientDao;
import com.patient.entity.Patient;
import com.patient.repository.PatientRepository;

@Component
public class PatientDaoImpl implements PatientDao {

	@Autowired
	public PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient create(Patient dto) {
		return patientRepository.saveAndFlush(dto);
	}

	@Override
	public Patient findById(Integer id) {
		Optional<Patient> patient = patientRepository.findById(id);
        return patient.isPresent() ? patient.get() : null;
	}

}
