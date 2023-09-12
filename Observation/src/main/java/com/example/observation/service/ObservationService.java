package com.example.observation.service;

import com.example.observation.dto.ObservationDTO;
import com.example.observation.entity.Observation;
import com.example.observation.repository.ObservationRepository;
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
        return observationRepository.save(observation);
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


}
