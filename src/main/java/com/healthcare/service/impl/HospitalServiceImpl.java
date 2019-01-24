package com.healthcare.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.Hospital;
import com.healthcare.repository.HospitalRepository;
import com.healthcare.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	HospitalRepository hospitalRepository;

	@Autowired
	public HospitalServiceImpl(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}

	@Override
	public List<Hospital> hospitalList() {
		return (List<Hospital>) hospitalRepository.findAll();
	}

	@Override
	public Optional<Hospital> findByHospitalId(Long id) {
		return hospitalRepository.findById(id);
	}

	@Override
	public Hospital addHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	public String deleteHospital(Long id) {
		hospitalRepository.deleteById(id);
		return "{'message' :'Hospital entry deleted successfully'}";
	}

}
