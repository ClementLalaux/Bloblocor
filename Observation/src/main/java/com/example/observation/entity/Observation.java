package com.example.observation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("observation")
public class Observation {

    @Id
    private String id;
    private Integer notation;
    private String comment;
    private Long idClient;
    private Long idReservation;

    public Observation(String id, Integer notation, String comment, Long idClient, Long idReservation) {
        this.id = id;
        this.notation = notation;
        this.comment = comment;
        this.idClient = idClient;
        this.idReservation = idReservation;
    }


}
