package com.doctor.controller;

import com.doctor.entity.Country;
import com.doctor.service.api.CountryServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nicu on 6/16/2016.
 */
@RestController
@RequestMapping(path = "/info")
public class PersonalInformationController {

    @Autowired
    private CountryServiceApi countryService;

    @RequestMapping(path = "/country", method = RequestMethod.POST )
    void addCountry(@RequestBody String name){
        countryService.addCountry(name);
    }

    @RequestMapping(path = "/country", method = RequestMethod.GET)
    List<Country> getAvailableCounries(){
        return countryService.getAvailableCountreies();
    }


}
