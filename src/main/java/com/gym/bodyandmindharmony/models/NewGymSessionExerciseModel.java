package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class NewGymSessionExerciseModel implements Model {

    @JsonProperty("exercise_name")
    private String name;

    @JsonProperty("repetitions")
    private int repetitions;

    @JsonProperty("weight")
    private double weight;
}
