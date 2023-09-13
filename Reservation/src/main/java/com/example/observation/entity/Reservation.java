package com.example.observation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departure;
    private String arrival;
    private String date;
    private Double price;
    private boolean isEnded;
    private Long driverId;
    private Long clientId;
    private Long estimationId;

}
