package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
@Schema(
        description = "All the stored information about a Gym Session."
)
public class GymSessionModel implements Model {

    @JsonProperty("id")
    @Schema(
            description = "The unique session id."
    )
    private final String id;

    @JsonProperty("date")
    @Schema(
            description = "The date of the session.", format = "date"
    )
    private final LocalDate date;

    @JsonProperty("type")
    @Schema(
            description = "The type of the Session."
    )
    private final String type;
}
