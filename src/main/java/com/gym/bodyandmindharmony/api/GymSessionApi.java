package com.gym.bodyandmindharmony.api;

import com.gym.bodyandmindharmony.models.GymSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GymSessionApi {

    ResponseEntity<List<GymSessionModel>> retrieveAllGymSessions(String username);

    ResponseEntity<GymSessionModel> createNewGymSession(NewGymSessionModel newGymSessionModel, String username);
}
