package com.example.observation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ObservationDTO {

    private Integer notation;
    private String comment;
    private boolean isEnded;
    private Long idClient;
    private Long idReservation;

}
