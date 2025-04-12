package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionExerciseModel;

public interface GymSessionExerciseMapper {

    GymExerciseSessionModel mapToModel(Exercise exercise);

    Exercise mapToNewEntity(NewGymSessionExerciseModel model);
}
