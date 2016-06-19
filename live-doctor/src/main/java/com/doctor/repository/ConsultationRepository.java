package com.doctor.repository;

import com.doctor.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nicu on 6/17/2016.
 */
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
