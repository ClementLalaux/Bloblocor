package com.example.observation.controller;

import com.example.observation.dto.ReservationDTO;
import com.example.observation.dto.TakeReservationDTO;
import com.example.observation.entity.Reservation;
import com.example.observation.service.ReservationService;
import com.example.observation.utils.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final Mapper mapper;


    public ReservationController(ReservationService reservationService, Mapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }
    
    @GetMapping("")
    public ResponseEntity<List<Reservation>> getAll(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }
    @PostMapping("")
    public ResponseEntity<Reservation> post(@RequestBody Reservation reservation1){
        Reservation reservation = reservationService.createReservation(reservation1);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TakeReservationDTO> getById(@PathVariable(value = "id") Long id){
        try {
            TakeReservationDTO takeReservationDTO = reservationService.getById(id);
            return ResponseEntity.ok(takeReservationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @GetMapping("/resbyuser/{userId}")
    public ResponseEntity<ReservationDTO> getByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(reservationService.getReservationByUserId(userId));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("/addclient/{clientId}/reservationid/{reservationId}")
    public ResponseEntity<TakeReservationDTO> addClientToReservation(@PathVariable Long clientId,@PathVariable Long reservationId){
        try {
            return ResponseEntity.ok(reservationService.addClientId(reservationId,clientId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update/{reservationId}")
    public ResponseEntity<TakeReservationDTO> updateReservation(@PathVariable Long reservationId,@RequestBody TakeReservationDTO reservation1){
        try {
            return ResponseEntity.ok(reservationService.updateReservation(reservationId,reservation1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long reservationId){
        try {
            if(reservationService.deleteReservation(reservationId)){
                return ResponseEntity.ok("Suppression réussie");
            }
            return ResponseEntity.status(401).body("Error delete");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/count/{reservationId}")
    public ResponseEntity<Integer> countReservationByUser(@PathVariable Long reservationId){
        try {
            return ResponseEntity.ok(reservationService.countById(reservationId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
