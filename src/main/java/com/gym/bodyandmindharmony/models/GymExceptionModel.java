package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.bodyandmindharmony.exception.GymException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GymExceptionModel implements Model {

    @JsonProperty("code")
    private int code;

    @JsonProperty("category")
    private String category;

    @JsonProperty("message")
    private String message;

    public GymExceptionModel(GymException exception) {
        this.code = exception.getCode();
        this.category = exception.getCategory();
        this.message = exception.getMessage();
    }
}
