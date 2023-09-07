package com.example.observation.repository;

import com.example.observation.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

    List<Reservation> findAllByUserId(Long userId);

}
