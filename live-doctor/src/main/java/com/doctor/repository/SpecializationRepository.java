package com.doctor.repository;

import com.doctor.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Nicu on 6/17/2016.
 */
@Transactional
@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
