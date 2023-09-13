package com.example.observation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

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
