package com.doctor.service.api;

import com.doctor.entity.Country;

import java.util.List;

/**
 * Created by Nicu on 6/16/2016.
 */
public interface CountryServiceApi {
    Country addCountry(String name);
    List<Country> getAvailableCountreies();
}
