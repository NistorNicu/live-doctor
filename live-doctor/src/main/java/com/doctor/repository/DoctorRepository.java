package com.doctor.repository;

import com.doctor.entity.Doctor;
import com.doctor.entity.Language;
import com.doctor.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Nicu on 6/17/2016.
 */
@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllBySpecializationAndLanguage(Specialization specialization, Language language);
}
