package com.doctor.repository;



import com.doctor.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Nicu on 6/16/2016.
 */
@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {
}
