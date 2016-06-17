package com.doctor.repository;

import com.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Nicu on 6/17/2016.
 */
@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
