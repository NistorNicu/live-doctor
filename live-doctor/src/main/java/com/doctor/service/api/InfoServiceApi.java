package com.doctor.service.api;

import com.doctor.entity.Country;
import com.doctor.entity.Language;
import com.doctor.entity.Specialization;

import java.util.List;

/**
 * Created by Nicu on 6/16/2016.
 */
public interface InfoServiceApi {
    Country addCountry(String name);
    List<Country> getAvailableCountreies();

    Language addLanguage(String name);
    List<Language> getAvailableLanguages();

    Specialization addSpecialization(String name);
    List<Specialization> getAvailableSpecializations();
}
