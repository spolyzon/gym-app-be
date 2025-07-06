package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GymUserLoginModel implements Model {

    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonCreator
    public GymUserLoginModel(String username) {
        this.username = username;
    }
}
