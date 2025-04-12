package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;

public interface GymSessionExerciseMapper {

    GymExerciseSessionModel mapToModel(Exercise exercise);
}
