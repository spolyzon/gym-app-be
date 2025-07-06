package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GymSessionModel implements Model {

    @JsonProperty("id")
    private String id;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("type")
    private String type;
}
