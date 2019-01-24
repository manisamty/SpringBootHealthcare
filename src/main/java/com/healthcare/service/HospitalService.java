package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import com.healthcare.entity.Hospital;

public interface HospitalService {

	List<Hospital> hospitalList();

	Optional<Hospital> findByHospitalId(Long id);

	Hospital addHospital(Hospital hospital);

	String deleteHospital(Long id);

}
