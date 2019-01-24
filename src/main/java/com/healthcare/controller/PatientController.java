package com.healthcare.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entity.Hospital;
import com.healthcare.entity.Patient;
import com.healthcare.repository.HospitalRepository;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.HospitalService;
import com.healthcare.service.PatientService;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

	private PatientService patientService;

	// private PatientsRepository patientsRepository;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	
	@GetMapping("/patient_list")
	public List<Patient> patientList() {
		return patientService.patientList();

	}

	
	@GetMapping("/hosp_list/{id}")
	public Optional<Patient> findByPatientId(@PathVariable Long id) {
		return patientService.findByPatientId(id);
	}

	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}

	
	@DeleteMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		return patientService.deletePatient(id);
	}

}