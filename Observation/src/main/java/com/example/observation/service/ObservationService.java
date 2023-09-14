package com.example.observation.service;

import com.example.observation.dto.ObservationDTO;
import com.example.observation.dto.ReservationDTO;
import com.example.observation.dto.UserDTO;
import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
import com.example.observation.tool.RestClient;
import com.example.observation.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    @Autowired
    Mapper mapper;


    public Observation createObservation(Observation observation){
        try{
            RestClient<UserDTO, String> restClientUser = new RestClient<>("http://localhost:8082/api/");
            RestClient<UserDTO, String> restClientDriver = new RestClient<>("http://localhost:8082/api/");

            RestClient<ReservationDTO, String> restClientReservation = new RestClient<>("http://localhost:8083/api/");

            UserDTO userDTO = restClientUser.get("user/"+observation.getIdClient(), UserDTO.class);
            UserDTO userDTO1 = restClientDriver.get("user/"+observation.getIdDriver(), UserDTO.class);
            ReservationDTO reservationDTO = restClientReservation.get("reservationadmin/"+observation.getIdReservation(), ReservationDTO.class);

            if(userDTO != null && userDTO1 != null && reservationDTO != null){
                return observationRepository.save(observation);
            } else {
                throw new RuntimeException("Not possible");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }

    public List<ObservationDTO> getAllObservations(){
        List<ObservationDTO> observationDTOS = new ArrayList<>();
        List<Observation> observations = observationRepository.findAll();
        for (Observation o:observations) {
            ObservationDTO observationDTO = mapper.mapToDto(o);
            observationDTOS.add(observationDTO);
        }
        return observationDTOS;
    }

    public ObservationDTO getById(String id){
        if(observationRepository.findById(id).isPresent()){
            Observation observation = observationRepository.findById(id).get();
            return mapper.mapToDto(observation);
        }
        throw new RuntimeException("Erreur");
    }

    public ObservationDTO updateObservation(String id, ObservationDTO observationDTO){
        if(observationRepository.findById(id).isPresent()){
            Observation observationGet = observationRepository.findById(id).get();
            observationGet.setComment(observationDTO.getComment());
            observationGet.setNotation(observationDTO.getNotation());
            observationRepository.save(observationGet);
            return mapper.mapToDto(observationGet);
        }
        throw new RuntimeException("Not found");
    }

    public boolean deleteObservation(String observationId){
        if(observationRepository.findById(observationId).isPresent()){
            Observation observation = observationRepository.findById(observationId).get();
            observationRepository.delete(observation);
            return true;
        }
        throw new RuntimeException("Error");
    }

//    public ObservationDTO getByMinimumNotation(Long userId){
//        RestClient<UserDTO, String> restClientUser = new RestClient<>("http://localhost:8082/api/");
//        UserDTO userDTO = restClientUser.get("user/"+userId, UserDTO.class);
//        if(userDTO != null){
//            Observation observation = observationRepository.searchByNotationMin(userId,userId);
//            return mapper.mapToDto(observation);
//        }else {
//            throw new RuntimeException("Not possible");
//        }
//    }
//
//    public ObservationDTO getByMaximumNotation(Long userId){
//        RestClient<UserDTO, String> restClientUser = new RestClient<>("http://localhost:8082/api/");
//        UserDTO userDTO = restClientUser.get("user/"+userId, UserDTO.class);
//        if(userDTO != null){
//            Observation observation = observationRepository.searchByNotationMax(userId,userId);
//            return mapper.mapToDto(observation);
//        }else {
//            throw new RuntimeException("Not possible");
//        }
//    }
//
//    public Double getByMoyenneNotation(Long userId){
//        RestClient<UserDTO, String> restClientUser = new RestClient<>("http://localhost:8082/api/");
//        UserDTO userDTO = restClientUser.get("user/"+userId, UserDTO.class);
//        if(userDTO != null){
//            Double moy = observationRepository.searchByNotationMoyenne(userId,userId);
//            return moy;
//        }else {
//            throw new RuntimeException("Not possible");
//        }
//    }

    public Integer getCountNotation(Long userId){
        RestClient<UserDTO, String> restClientUser = new RestClient<>("http://localhost:8082/api/");
        UserDTO userDTO = restClientUser.get("user/"+userId, UserDTO.class);
        if(userDTO != null){
            return observationRepository.countObservationByIdDriverOrIdClient(userId,userId);
        }else {
            throw new RuntimeException("Not possible");
        }
    }


}
