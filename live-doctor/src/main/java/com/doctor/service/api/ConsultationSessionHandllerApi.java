package com.doctor.service.api;

import com.opentok.Role;
import com.opentok.Session;
import com.opentok.exception.OpenTokException;

/**
 * Created by Nicu on 6/18/2016.
 */
public interface ConsultationSessionHandllerApi {
    Session createSession();
    String generateToken(Session session, Role role);
}
