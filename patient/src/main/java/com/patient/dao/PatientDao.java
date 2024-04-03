package com.patient.dao;

import com.patient.entity.Patient;

import java.util.List;

public interface PatientDao {
	List<Patient> getAllPatients();
	Patient create(Patient dto);
	Patient findById(Integer id);
}
