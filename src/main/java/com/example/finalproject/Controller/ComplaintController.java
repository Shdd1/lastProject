package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Complaint;
import com.example.finalproject.Serveice.ComplaintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/complaint")
public class ComplaintController {
    private final ComplaintService complaintService;
    @GetMapping("/get")
    public ResponseEntity getAllComplaint(){
        return ResponseEntity.status(200).body(complaintService.getAllComplaint());
    }

    @PostMapping("/add")
    public ResponseEntity addComplaint(@Valid @RequestBody Complaint complaint){
        complaintService.addNewComplaint(complaint);
        return ResponseEntity.status(200).body(new ApiResponse("Complaint successfully added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComplaint (@PathVariable Integer id , @Valid @RequestBody Complaint complaint){
        complaintService.updateComplaint(id, complaint);
        return ResponseEntity.status(200).body(new ApiResponse("Complaint successfully updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComplaint(@PathVariable Integer id){
        complaintService.deleteComplaint(id);
        return ResponseEntity.status(200).body(new ApiResponse("Complaint successfully deleted"));
    }
}
