package com.example.observation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("observation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Observation {

    @Id
    private String id;
    private Integer notation;
    private String comment;
    private boolean isEnded;
    private Long idClient;
    private Long idDriver;
    private Long idReservation;


    public Observation(String id, Integer notation, String comment,Long idDriver, Long idClient, Long idReservation) {
        this.id = id;
        this.notation = notation;
        this.comment = comment;
        this.idClient = idClient;
        this.idDriver = idDriver;
        this.idReservation = idReservation;
    }

    public Observation(Integer notation, String comment, Long idDriver, Long idClient, Long idReservation) {
        this.notation = notation;
        this.comment = comment;
        this.idDriver = idDriver;
        this.idClient = idClient;
        this.idReservation = idReservation;
    }

    public Observation(Integer notation, String comment, Long idDriver, Long idClient, Long idReservation, boolean isEnded) {
        this.notation = notation;
        this.comment = comment;
        this.idDriver = idDriver;
        this.idClient = idClient;
        this.idReservation = idReservation;
        this.isEnded = isEnded;
    }
}
