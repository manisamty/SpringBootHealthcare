package com.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Examination;
import com.healthcare.entity.Patient;
import com.healthcare.repository.ExaminationRepository;
import com.healthcare.repository.HospitalRepository;
import com.healthcare.repository.PatientRepository;
import com.healthcare.service.ExaminationService;

@Service
public class ExaminationServiceImpl implements ExaminationService {

	PatientRepository patientsRepository;
	HospitalRepository hospitalRepository;
	ExaminationRepository examinationRepository;

	@Autowired
	public ExaminationServiceImpl(HospitalRepository hospitalRepository, PatientRepository patientsRepository,
			ExaminationRepository examinationRepository) {
		this.patientsRepository = patientsRepository;
		this.hospitalRepository = hospitalRepository;
		this.examinationRepository = examinationRepository;
	}

	@Override
	public List<Examination> examinationList() {
		return (List<Examination>) examinationRepository.findAll();
	}

	@Override
	public Optional<Examination> findByExaminationId(Long id) {
		return examinationRepository.findById(id);
	}

	@Override
	public Examination addExamination(Examination examination) {
		examination.setPatient(patientsRepository.getOne(examination.getPet_id()));
		return examinationRepository.save(examination);
	}

	@Override
	public String deleteExamination(Long id) {
		examinationRepository.deleteById(id);
		return "{'message' :'Examination entry deleted successfully'}";
	}

}
