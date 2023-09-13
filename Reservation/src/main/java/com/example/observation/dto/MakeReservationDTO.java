package com.example.observation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeReservationDTO {
    private Long id;
    private String departure;
    private String arrival;
    private String date;
    private boolean isEnded;
    private Double price;
    private Long driverId;
    private Long estimationId;

}
