package com.gym.bodyandmindharmony.api;

import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionExerciseModel;
import com.gym.bodyandmindharmony.models.UpdateGymSessionExerciseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GymSessionExerciseApi {

    ResponseEntity<List<GymExerciseSessionModel>> getAllExercises(String gymSessionId);

    ResponseEntity<Void> addExercise(String gymSessionId, NewGymSessionExerciseModel newGymSessionExerciseModel);

    ResponseEntity<Void> updateExercise(String gymSessionId, UpdateGymSessionExerciseModel updateGymSessionExerciseModel);
}
