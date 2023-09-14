package com.example.observation.repository;

import com.example.observation.entity.Observation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.Document;

@Repository
public interface ObservationRepository extends MongoRepository<Observation,String> {

    @Query(value = "SELECT notation FROM Observation WHERE driverId = driverId OR clientId = clientId ASC LIMIT 1")
    Observation searchByNotationMax(Long driverId, Long clientId);

    @Query(value = "SELECT notation FROM Observation WHERE driverId = driverId OR clientId = clientId DESC LIMIT 1")
    Observation searchByNotationMin(Long driverId, Long clientId);

    @Query(value = "SELECT AVG(notation) FROM Observation WHERE driverId = driverId OR clientId = clientId")
    Double searchByNotationMoyenne(Long driverId, Long clientId);

    @Query(value = "SELECT COUNT(*) FROM Observation WHERE driverId = driverId OR clientId = clientId")
    Integer countObservationByDriverIdOrClientId(Long driverId,Long clientId);

}
