package com.example.finalproject.Serveice;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Consultation;
import com.example.finalproject.Repository.ConsultationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public void addNewConsultation(Consultation consultation) {
        consultationRepository.save(consultation);
    }

    public void updateConsultation(Integer id,Consultation consultation) {
        Consultation consultation1 = consultationRepository.findConsultationById(id);

        if (consultation1 == null) {
           throw new ApiException("Consultation not found");
        }

        consultation1.setConsultationDate(consultation.getConsultationDate());
        consultation1.setDuration(consultation.getDuration());
        consultationRepository.save(consultation1);
    }


    public void deleteConsultation(Integer id) {
        Consultation consultation1 = consultationRepository.findConsultationById(id);
        if (consultation1 == null) {
            throw new ApiException("Consultation not found");
        }
        consultationRepository.delete(consultation1);
    }

}
