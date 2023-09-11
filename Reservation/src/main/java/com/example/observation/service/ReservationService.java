package com.example.observation.service;

import com.example.observation.dto.*;
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
            return mapper.mapToDto(reservation);
        }
        throw new RuntimeException("Not found");
    }

    public ReservationDTO getReservationByUserId(Long userId){
        RestClient<UserDTO, String> restClient = new RestClient<>("http://localhost:8082/api/");
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .reservations(reservationRepository.findAllByDriverIdOrClientId(userId,userId))
                .userDTO(restClient.get("user/"+userId,UserDTO.class))
                .build();
        System.out.println(reservationDTO);
        return reservationDTO;
    }

    public TakeReservationDTO addClientId(MakeReservationDTO reservationDTO, Long clientId){
        RestClient<UserDTO, String> restClient = new RestClient<>("http://localhost:8082/api/");
        UserDTO userDTO = restClient.get("user"+clientId, UserDTO.class);
        Reservation reservation = mapper.mapToEntity(reservationDTO);
        if(userDTO != null && reservation !=null){
            reservation.setClientId(clientId);
            reservationRepository.save(reservation);
            TakeReservationDTO takeReservationDTO = mapper.mapToDtoTake(reservation);
            return takeReservationDTO;
        }
        throw new RuntimeException("Not found");
    }
}
