package com.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Patient;
import com.healthcare.repository.HospitalRepository;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	PatientRepository patientsRepository;
	HospitalRepository hospitalRepository;

	@Autowired
	public PatientServiceImpl(HospitalRepository hospitalRepository, PatientRepository patientsRepository) {
		this.patientsRepository = patientsRepository;
		this.hospitalRepository = hospitalRepository;
	}

	@Override
	public List<Patient> patientList() {
		return (List<Patient>) patientsRepository.findAll();
	}

	@Override
	public Optional<Patient> findByPatientId(Long id) {
		return patientsRepository.findById(id);
	}

	@Override
	public Patient addPatient(Patient patient) {
		patient.setHospital(hospitalRepository.getOne(patient.getHos_id()));
		return patientsRepository.save(patient);
	}

	@Override
	public String deletePatient(Long id) {
		patientsRepository.deleteById(id);
		return "{'message' :'Patient entry deleted successfully'}";
	}

}
