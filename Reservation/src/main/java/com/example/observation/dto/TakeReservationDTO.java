package com.example.observation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TakeReservationDTO {
    private Long id;
    private String departure;
    private String arrival;
    private String date;
    private Double price;
    private Long driverId;
    private Long clientId;
    private Long estimationId;

}
