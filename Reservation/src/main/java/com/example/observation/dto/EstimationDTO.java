package com.example.observation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstimationDTO {
    private Long id;
    private Integer rating;
    private String comment;
}
