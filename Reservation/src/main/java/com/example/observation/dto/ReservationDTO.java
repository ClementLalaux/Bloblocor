package com.example.observation.dto;

import com.example.observation.entity.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReservationDTO {
    private List<Reservation> reservations;
    private UserDTO userDTO;

    private EstimationDTO estimationDTO;
}
