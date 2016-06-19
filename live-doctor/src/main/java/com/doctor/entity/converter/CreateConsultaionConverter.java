package com.doctor.entity.converter;

import com.doctor.entity.Consultation;
import com.doctor.entity.view.CreateConsultationView;
import com.doctor.repository.PacientRepository;
import com.doctor.repository.SpecializationRepository;
import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Nicu on 6/17/2016.
 */
@Component
public class CreateConsultaionConverter extends Converter<CreateConsultationView, Consultation> {

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    PacientRepository pacientRepository;

    @Override
    protected Consultation doForward(CreateConsultationView createConsultationView) {
        Consultation c = new Consultation();
        c.setSpecialization(specializationRepository.findOne(createConsultationView.getSpecializationId()));
        c.setPacient(pacientRepository.findOne(createConsultationView.getPacientId()));
        return c;
    }

    @Override
    protected CreateConsultationView doBackward(Consultation consultation) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
