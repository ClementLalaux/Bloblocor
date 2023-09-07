package com.example.observation.service;

import com.example.observation.dto.EstimationDTO;
import com.example.observation.dto.MakeReservationDTO;
import com.example.observation.dto.ReservationDTO;
import com.example.observation.dto.UserDTO;
import com.example.observation.entity.Reservation;
import com.example.observation.repository.ReservationRepository;
import com.example.observation.tool.RestClient;
import com.example.observation.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final Mapper mapper;


    public ReservationService(ReservationRepository reservationRepository, Mapper mapper) {
        this.reservationRepository = reservationRepository;
        this.mapper = mapper;
    }

    public Reservation createReservation(Reservation reservation){
        Reservation newReservation = reservationRepository.save(reservation);
        return newReservation;
    }

    public List<Reservation> getAllReservations(){
        return (List<Reservation>) reservationRepository.findAll();
    }

    public MakeReservationDTO getById(Long id){
        if(reservationRepository.findById(id).isPresent()){
            Reservation reservation = reservationRepository.findById(id).get();
            //MakeReservationDTO makeReservationDTO = new MakeReservationDTO(reservation.getDeparture(), reservation.getArrival(), reservation.getDate(), reservation.getPrice(), reservation.getUserId(), reservation.getEstimationId());
            return mapper.mapToDto(reservation);
        }
        throw new RuntimeException("Not found");
    }



}
