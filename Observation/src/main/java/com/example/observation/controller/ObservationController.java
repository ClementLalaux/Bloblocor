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
    public ResponseEntity<String> post(@RequestBody Observation observation){
        try {
            observationService.createObservation(observation);
            return ResponseEntity.ok("Observation ajouté");
        }catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("/update/{observationId}")
    public ResponseEntity<ObservationDTO> updateObservation(@PathVariable String observationId, @RequestBody ObservationDTO observationDTO){
        try {
            return ResponseEntity.ok(observationService.updateObservation(observationId,observationDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{observationId}")
    public ResponseEntity<String> deleteObservation(@PathVariable String observationId){
        try {
            if(observationService.deleteObservation(observationId)){
                return ResponseEntity.ok("Suppression réussie");
            }
            return ResponseEntity.status(401).body("Error delete");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
