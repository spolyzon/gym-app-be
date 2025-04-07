package com.gym.bodyandmindharmony.api;

import com.gym.bodyandmindharmony.models.GymSessionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(
        name = "Gym Sessions API",
        description = "List of all available endpoints to retrieve information about Gym Sessions."
)
public interface GymSessionApi {

    @Operation(summary = "Returns all the previous Gym Sessions.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "All Gym Sessions returned successfully.",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = GymSessionModel.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Something went wrong while retrieving Gym Sessions"
            )
    })
    ResponseEntity<List<GymSessionModel>> retrieveAllGymSessions();
}
