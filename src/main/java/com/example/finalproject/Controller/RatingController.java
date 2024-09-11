package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Consultation;
import com.example.finalproject.Model.Rating;
import com.example.finalproject.Serveice.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;
    @GetMapping("/get")
    public ResponseEntity getAllRating(){
        return ResponseEntity.status(200).body(ratingService.getAllRating());
    }

    @PostMapping("/add")
    public ResponseEntity addRating(@Valid @RequestBody Rating rating){
        ratingService.addNewRating(rating);
        return ResponseEntity.status(200).body(new ApiResponse("Rating successfully added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRating(@PathVariable Integer id , @Valid @RequestBody Rating rating){
        ratingService.updateRating(id, rating);
        return ResponseEntity.status(200).body(new ApiResponse("Rating successfully updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRating(@PathVariable Integer id){
        ratingService.deleteRating(id);
        return ResponseEntity.status(200).body(new ApiResponse("Rating successfully deleted"));
    }
}
