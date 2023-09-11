package com.example.observation.repository;

import com.example.observation.entity.Observation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends MongoRepository<Observation,String> {

}
