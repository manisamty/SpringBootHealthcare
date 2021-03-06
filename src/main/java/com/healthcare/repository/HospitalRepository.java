package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
