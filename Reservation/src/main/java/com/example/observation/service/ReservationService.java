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
            return mapper.mapToDto(reservation);
        }
        throw new RuntimeException("Not found");
    }

    public ReservationDTO getReservationByUserId(Long userId){
        RestClient<UserDTO, String> restClient = new RestClient<>();

        System.out.println("Avant de récupérer les réservations");
        List<Reservation> reservations = reservationRepository.findAllByUserId(userId);
        System.out.println("Après de récupérer les réservations");

        System.out.println("Avant de récupérer l'utilisateur");
        UserDTO userDTO = restClient.get("user/"+userId, UserDTO.class);
        System.out.println("Après de récupérer l'utilisateur");
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .reservations(reservationRepository.findAllByUserId(userId))
                .userDTO(restClient.get("user/"+userId,UserDTO.class))
                .build();
        System.out.println(reservationDTO);
        return reservationDTO;
    }



}
