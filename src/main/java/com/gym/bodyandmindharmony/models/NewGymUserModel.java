package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NewGymUserModel implements Model {

    @JsonProperty(value = "firstName", required = true)
    private String firstName;

    @JsonProperty(value = "lastName", required = true)
    private String lastName;

    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonCreator
    public NewGymUserModel(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }
}
