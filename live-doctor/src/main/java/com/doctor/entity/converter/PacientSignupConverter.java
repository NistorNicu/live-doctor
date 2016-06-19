package com.doctor.entity.converter;

import com.doctor.entity.Pacient;
import com.doctor.entity.view.PacientSignupView;
import com.doctor.repository.CountryRepository;
import com.doctor.repository.LanguageReposiltory;
import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nicu on 6/17/2016.
 */
@Component
public class PacientSignupConverter extends Converter<PacientSignupView, Pacient> {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LanguageReposiltory languageReposiltory;

    @Override
    protected Pacient doForward(PacientSignupView pacientSignupView) {
        Pacient p = new Pacient();
        p.setLanguage(languageReposiltory.findOne(pacientSignupView.getLanguageId()));
        p.setCountry(countryRepository.findOne(pacientSignupView.getCountryId()));
        p.setName(pacientSignupView.getName());
        return p;
    }

    @Override
    protected PacientSignupView doBackward(Pacient pacient) {
        throw  new UnsupportedOperationException("Not implemented !");
    }
}
