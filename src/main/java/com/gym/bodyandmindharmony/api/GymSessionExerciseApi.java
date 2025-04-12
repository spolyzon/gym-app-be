package com.gym.bodyandmindharmony.api;

import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GymSessionExerciseApi {

    ResponseEntity<List<GymExerciseSessionModel>> getAllExercises(String gymSessionId);
}
