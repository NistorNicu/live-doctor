package com.doctor.entity.converter;

import com.doctor.entity.Consultation;
import com.doctor.entity.view.ConsultationPacientView;
import com.google.common.base.Converter;

/**
 * Created by Nicu on 7/3/2016.
 */
@Deprecated
public class ConsultationPacientConverter extends Converter<Consultation, ConsultationPacientView> {
    @Override
    protected ConsultationPacientView doForward(Consultation consultation) {
        ConsultationPacientView view = new ConsultationPacientView();
        return null;
    }

    @Override
    protected Consultation doBackward(ConsultationPacientView consultationPacientView) {
        return null;
    }
}
