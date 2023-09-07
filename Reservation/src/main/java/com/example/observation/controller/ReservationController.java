package com.example.observation.controller;

import com.example.observation.dto.MakeReservationDTO;
import com.example.observation.dto.ReservationDTO;
import com.example.observation.entity.Reservation;
import com.example.observation.service.ReservationService;
import com.example.observation.tool.RestClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("test");
    }
    @PostMapping("")
    public ResponseEntity<Reservation> post(@RequestBody Reservation reservation1){
        Reservation reservation = reservationService.createReservation(reservation1);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MakeReservationDTO> getById(@PathVariable(value = "id") Long id){
        try {
            MakeReservationDTO makeReservationDTO = reservationService.getById(id);
            return ResponseEntity.ok(makeReservationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }


}
