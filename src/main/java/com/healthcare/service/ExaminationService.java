package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import com.healthcare.entity.Examination;
import com.healthcare.entity.Hospital;

public interface ExaminationService {

	List<Examination> examinationList();

	Optional<Examination> findByExaminationId(Long id);

	Examination addExamination(Examination examination);

	String deleteExamination(Long id);

}
