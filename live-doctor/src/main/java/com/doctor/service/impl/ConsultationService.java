package com.doctor.service.impl;

import com.doctor.entity.Consultation;
import com.doctor.entity.Doctor;
import com.doctor.entity.converter.CreateConsultaionConverter;
import com.doctor.entity.view.ConsultationPacientView;
import com.doctor.entity.view.CreateConsultationView;
import com.doctor.repository.ConsultationRepository;
import com.doctor.service.api.ConsultationServiceApi;
import com.doctor.service.api.ConsultationSessionHandllerApi;
import com.doctor.service.api.DoctorServiceApi;
import com.opentok.Role;
import com.opentok.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Nicu on 6/17/2016.
 */
@Service
public class ConsultationService implements ConsultationServiceApi {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorServiceApi doctorServiceApi;

    @Autowired
    private CreateConsultaionConverter createConsultaionConverter;

    @Autowired
    private ConsultationSessionHandllerApi consultationSessionHandllerApi;


    public ConsultationPacientView createConsultation(CreateConsultationView createConsultationView){
        Consultation consultation = createConsultaionConverter.convert(createConsultationView);
        List<Doctor> docs = doctorServiceApi.findEligibleDoctors(consultation);
        Session session = consultationSessionHandllerApi.createSession();

        consultation.setSessionId(session.getSessionId());
        consultationRepository.deleteAll();
        consultationRepository.saveAndFlush(consultation);
        ConsultationPacientView pacientView = new ConsultationPacientView();
        pacientView.setSessionId(session.getSessionId());
        pacientView.setAvailableDoctors(docs);
        pacientView.setDocotrToken(consultationSessionHandllerApi.generateToken(session, Role.MODERATOR));
        pacientView.setPacientToken(consultationSessionHandllerApi.generateToken(session, Role.MODERATOR));
        System.out.println("crates session : " + consultation.getSessionId());
        return pacientView;
    }

    @Override
    public Consultation getConsultation(Long id) {
        Optional<Consultation> opConsultaion = Optional.of(consultationRepository.findOne(id));
        if (opConsultaion.isPresent()){
            return opConsultaion.get();
        }else {
            throw new EntityNotFoundException("No consultation with id : " + id);
        }
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }
}
