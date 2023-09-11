package com.example.observation.service;

import com.example.observation.dto.ObservationDTO;
import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
import com.example.observation.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    @Autowired
    Mapper mapper;


    public Observation createObservation(Observation observation){
        Observation newObservation = observationRepository.save(observation);
        return newObservation;
    }

    public List<Observation> getAllObservations(){
        return observationRepository.findAll();
    }

    public ObservationDTO getById(String id){
        if(observationRepository.findById(id).isPresent()){
            Observation observation = observationRepository.findById(id).get();
            ObservationDTO observationDTO = mapper.mapToDto(observation);
            return observationDTO;
        }
        throw new RuntimeException("Erreur");
    }


}
