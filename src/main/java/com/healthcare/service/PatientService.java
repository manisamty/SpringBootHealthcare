package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import com.healthcare.entity.Patient;

public interface PatientService {

	List<Patient> patientList();

	Optional<Patient> findByPatientId(Long id);

	Patient addPatient(Patient patient);

	String deletePatient(Long id);

}
