package com.gym.bodyandmindharmony.api;

import com.gym.bodyandmindharmony.models.GymSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionModel;
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
                    description = "Something went wrong while retrieving Gym Sessions",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    })
    ResponseEntity<List<GymSessionModel>> retrieveAllGymSessions();

    @Operation(summary = "Creates a new Gym Session")
    @ApiResponses(value = {
                  @ApiResponse(
                          responseCode = "201",
                          description = "New Gym Session successfully created.",
                          content = @Content(
                                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                                  schema = @Schema(implementation = GymSessionModel.class)
                          )
                  )
            }
    )
    ResponseEntity<GymSessionModel> createNewGymSession(NewGymSessionModel newGymSessionModel);
}
