package com.gym.bodyandmindharmony.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private String id;

    @JsonProperty("date")
    @Schema(
            description = "The date of the session.", format = "date"
    )
    private LocalDate date;

    @JsonProperty("type")
    @Schema(
            description = "The type of the Session."
    )
    private String type;
}
