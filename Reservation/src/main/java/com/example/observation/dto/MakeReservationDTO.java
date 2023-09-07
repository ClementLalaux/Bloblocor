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

    private String departure;
    private String arrival;
    private String date;
    private Double price;
    private Long userId;
    private Long estimationId;

}
