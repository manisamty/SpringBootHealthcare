package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long>{

}
