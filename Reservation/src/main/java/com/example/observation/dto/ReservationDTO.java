package com.example.observation.dto;

import com.example.observation.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReservationDTO {
    private List<Reservation> reservations;
    private UserDTO userDTO;

    private EstimationDTO estimationDTO;
}
