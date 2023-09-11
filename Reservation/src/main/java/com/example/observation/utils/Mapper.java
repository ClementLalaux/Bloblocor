package com.example.observation.utils;

import com.example.observation.dto.MakeReservationDTO;
import com.example.observation.dto.TakeReservationDTO;
import com.example.observation.entity.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public MakeReservationDTO mapToDto(Reservation reservation) {

        ModelMapper mapper = new ModelMapper();
        return mapper.map(reservation, MakeReservationDTO.class);

    }
    public Reservation mapToEntity(MakeReservationDTO makeReservationDTO) {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(makeReservationDTO, Reservation.class);
    }

    public TakeReservationDTO mapToDtoTake(Reservation reservation){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reservation, TakeReservationDTO.class);
    }

    public Reservation mapToEntityTake(TakeReservationDTO takeReservationDTO) {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(takeReservationDTO, Reservation.class);
    }
}
