package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Schema(
        description = "The Required information to create a new Gym Session"
)
public class NewGymSessionModel {

    @JsonProperty("type")
    private String type;
}
