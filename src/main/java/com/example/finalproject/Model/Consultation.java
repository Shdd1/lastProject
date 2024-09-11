package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Consultation date should not be Empty!")
    @JsonFormat(pattern= "yyyy-MM-dd")
    @FutureOrPresent
    @Column(columnDefinition = "datetime not null")
    private LocalDate consultationDate;

    @NotNull(message = "Duration should not be null!")
    @Column(columnDefinition = "DOUBLE not null")
    private double duration;

    @Pattern(regexp = "^(Pending|Scheduled|Completed|Canceled)$" , message = "status has three valid inputs only,Pending, Scheduled, Completed or Canceled!")
    private String status;



    //Many consultation to one Investor
//    @ManyToOne
//    @JsonIgnore
//    private Investor investor;


    //Many consultation to one Owner
//    @ManyToOne
//    @JsonIgnore
//    private Owner owner;


}
