package com.example.observation.repository;

import com.example.observation.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

    List<Reservation> findAllByDriverIdOrClientId(Long driverId,Long clientId);

    @Query(value = "SELECT COUNT(*) FROM Reservation WHERE driverId = driverId OR clientId = clientId")
    Integer countByDriverIdOrClientId(Long driverId,Long clientId);
}
