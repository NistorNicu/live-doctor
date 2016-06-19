package com.doctor.service.impl;

/**
 * Created by Nicu on 6/16/2016.
 */

import com.doctor.entity.Country;
import com.doctor.entity.Language;
import com.doctor.entity.Specialization;
import com.doctor.repository.CountryRepository;
import com.doctor.repository.LanguageReposiltory;
import com.doctor.repository.SpecializationRepository;
import com.doctor.service.api.InfoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService implements InfoServiceApi {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LanguageReposiltory languageReposiltory;

    @Autowired
    private SpecializationRepository specializationRepository;

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

    @Override
    public Language addLanguage(String name) {
        Language l = new Language();
        l.setName(name);
        l = languageReposiltory.saveAndFlush(l);
        return l;
    }
    @Override
    public List<Language> getAvailableLanguages() {
        return languageReposiltory.findAll();
    }

    @Override
    public Specialization addSpecialization(String name) {
        Specialization p = new Specialization();
        p.setName(name);
        return specializationRepository.saveAndFlush(p);
    }

    @Override
    public List<Specialization> getAvailableSpecializations() {
        return specializationRepository.findAll();
    }

}
