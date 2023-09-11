package com.example.observation.controller;

import com.example.observation.dto.ObservationDTO;
import com.example.observation.entity.Observation;
import com.example.observation.service.ObservationService;
import com.example.observation.utils.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationController {

    private final ObservationService observationService;

    private final Mapper mapper;

    public ObservationController(ObservationService observationService, Mapper mapper) {
        this.observationService = observationService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ObservationDTO>> getAll(){
        try {
            List<ObservationDTO> observationDTOS = new ArrayList<>();
            List<Observation> observations = observationService.getAllObservations();
            for (Observation o: observations) {
                ObservationDTO observationDTO = mapper.mapToDto(o);
                observationDTOS.add(observationDTO);
            }
            return ResponseEntity.ok(observationDTOS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ObservationDTO> getById(@PathVariable(value = "id") String id){
        try {
            ObservationDTO observationDTO = observationService.getById(id);
            return ResponseEntity.ok(observationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> post(@RequestBody ObservationDTO observationDTO){
        try {
            Observation observation = mapper.mapToEntity(observationDTO);
            if(observationService.createObservation(observation) != null){
                return ResponseEntity.ok("Observation ajouté");
            }
            return ResponseEntity.status(401).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }


}