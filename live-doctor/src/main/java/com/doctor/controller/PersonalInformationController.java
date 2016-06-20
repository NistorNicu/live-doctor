package com.doctor.controller;

import com.doctor.entity.Country;
import com.doctor.entity.Language;
import com.doctor.entity.Specialization;
import com.doctor.service.api.InfoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nicu on 6/16/2016.
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/info")
public class PersonalInformationController {

    @Autowired
    private InfoServiceApi infoService;

    @RequestMapping(path = "/country", method = RequestMethod.POST )
    void addCountry(@RequestBody String name){
        infoService.addCountry(name);
    }

    @RequestMapping(path = "/country", method = RequestMethod.GET)
    List<Country> getAvailableCounries(){
        return infoService.getAvailableCountreies();
    }

    @RequestMapping(path = "/language", method = RequestMethod.POST )
    void addLanguage(@RequestBody String name){
        infoService.addLanguage(name);
    }

    @RequestMapping(path = "/language", method = RequestMethod.GET)
    List<Language> getAvailableLanguages(){
        return infoService.getAvailableLanguages();
    }

    @RequestMapping(path = "/specialization", method = RequestMethod.POST )
    void addSpecialization(@RequestBody String name){
        infoService.addSpecialization(name);
    }

    @RequestMapping(path = "/specialization", method = RequestMethod.GET)
    List<Specialization> getAvailableSpecializations(){
        return infoService.getAvailableSpecializations();
    }
}
