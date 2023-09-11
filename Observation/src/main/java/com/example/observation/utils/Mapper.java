package com.example.observation.utils;

import com.example.observation.dto.ObservationDTO;
import com.example.observation.entity.Observation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ObservationDTO mapToDto(Observation observation) {

        ModelMapper mapper = new ModelMapper();
        return mapper.map(observation, ObservationDTO.class);

    }

    public Observation mapToEntity(ObservationDTO observationDTO) {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(observationDTO, Observation.class);
    }

}
