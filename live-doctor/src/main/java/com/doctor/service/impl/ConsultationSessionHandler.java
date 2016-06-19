package com.doctor.service.impl;

import com.doctor.service.api.ConsultationSessionHandllerApi;
import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.exception.OpenTokException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by Nicu on 6/18/2016.
 */
@Service
public class ConsultationSessionHandler implements ConsultationSessionHandllerApi {

    private final OpenTok ot;

    private static final Integer API_KEY = 45608962;
    private static final String SECRET = "d68419078e5680abe299ac293f9e4061af3b4382";

    public ConsultationSessionHandler() {
        ot = new OpenTok(API_KEY, SECRET);
    }

    @Override
    public Session createSession() {
        try {
            return ot.createSession();
        } catch (OpenTokException e) {
            e.printStackTrace();
        }
        return null;
    }
}
