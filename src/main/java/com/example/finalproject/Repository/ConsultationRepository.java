package com.example.finalproject.Repository;

import com.example.finalproject.Model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
    Consultation findConsultationById(Integer id);
}
