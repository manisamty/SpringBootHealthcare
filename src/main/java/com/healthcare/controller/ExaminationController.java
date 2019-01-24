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

import com.healthcare.entity.Examination;
import com.healthcare.entity.Hospital;
import com.healthcare.entity.Patient;
import com.healthcare.repository.HospitalRepository;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.ExaminationService;
import com.healthcare.service.HospitalService;
import com.healthcare.service.PatientService;

@RestController
@RequestMapping(path = "/examination")
public class ExaminationController {

	private ExaminationService examinationService;

	// private PatientsRepository patientsRepository;

	public ExaminationController(ExaminationService examinationService) {
		this.examinationService = examinationService;
	}

	
	@GetMapping("/exam_list")
	public List<Examination> examinationList() {
		return examinationService.examinationList();

	}

	@GetMapping("/exam_list/{id}")
	public Optional<Examination> findByExaminationId(@PathVariable Long id) {
		return examinationService.findByExaminationId(id);
	}

	
	@PostMapping("/add")
	public Examination addExamination(@RequestBody Examination examination) {
		return examinationService.addExamination(examination);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteExamination(@PathVariable Long id) {
		return examinationService.deleteExamination(id);
	}

}