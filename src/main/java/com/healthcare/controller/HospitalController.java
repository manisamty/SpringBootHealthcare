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

@RestController
@RequestMapping(path = "/hospital")
public class HospitalController {

	private HospitalService hospitalService;

	// private PatientsRepository patientsRepository;

	public HospitalController(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}
	
	
	@GetMapping("/hosp_list")
	public List<Hospital> hospitalList() {
		return hospitalService.hospitalList();

	}

	
	@GetMapping("/hosp_list/{id}")
	public Optional<Hospital> findByHospitalId(@PathVariable Long id) {
		return hospitalService.findByHospitalId(id);
	}

	
	@PostMapping("/add")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		return hospitalService.addHospital(hospital);
	}

	
	@DeleteMapping("/delete/{id}")
	public String deleteHospital(@PathVariable Long id) {
		return hospitalService.deleteHospital(id);
	}

}