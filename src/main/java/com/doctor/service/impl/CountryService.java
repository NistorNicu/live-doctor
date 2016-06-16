package com.doctor.service.impl;

/**
 * Created by Nicu on 6/16/2016.
 */

import com.doctor.entity.Country;
import com.doctor.repository.CountryRepository;
import com.doctor.service.api.CountryServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@javax.transaction.Transactional
public class CountryService implements CountryServiceApi {

    @Autowired
    private CountryRepository countryRepository;

    public Country addCountry(String name){
        Country c = new Country();
        c.setName(name);
        c =  countryRepository.saveAndFlush(c);
        return c;
    }

    @Override
    public List<Country> getAvailableCountreies() {
        return countryRepository.findAll();
    }

}
