package com.example.finalproject.Repository;

import com.example.finalproject.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
    Complaint findComplaintsById(Integer id);
}
