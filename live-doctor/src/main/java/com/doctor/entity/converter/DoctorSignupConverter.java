package com.doctor.entity.converter;

import com.doctor.entity.Doctor;
import com.doctor.entity.view.DoctorSignupView;
import com.doctor.repository.CountryRepository;
import com.doctor.repository.LanguageReposiltory;
import com.doctor.repository.SpecializationRepository;
import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nicu on 6/17/2016.
 */
@Component
public class DoctorSignupConverter extends Converter<DoctorSignupView, Doctor> {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LanguageReposiltory languageReposiltory;
    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    protected Doctor doForward(DoctorSignupView doctorSignupView) {
        Doctor d = new Doctor();
        d.setName(doctorSignupView.getName());
        d.setCountry(countryRepository.findOne(doctorSignupView.getCountryId()));
        d.setLanguage(languageReposiltory.findOne(doctorSignupView.getLanguageId()));
        d.setSpecialization(specializationRepository.findOne(doctorSignupView.getSpecializationId()));
        return d;
    }

    @Override
    protected DoctorSignupView doBackward(Doctor doctor) {
        throw new UnsupportedOperationException("not implemented");
    }
}
