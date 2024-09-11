package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @NotNull(message ="score can not be null" )
    private int score;

    @Column(columnDefinition = "varchar(100) not null")
    @NotEmpty(message = "comment can not be empty")
    private String comment;


    //Many Rating to one Investor
//    @ManyToOne
//    @JsonIgnore
//    private Investor investor;


    //Many Rating to one Owner
//    @ManyToOne
//    @JsonIgnore
//    private Owner owner;
}
