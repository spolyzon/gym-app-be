package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionExerciseModel;
import com.gym.bodyandmindharmony.models.UpdateGymSessionExerciseModel;

public interface GymSessionExerciseMapper {

    GymExerciseSessionModel mapToModel(Exercise exercise);

    Exercise mapToNewEntity(NewGymSessionExerciseModel model);

    Exercise mapToUpdateEntity(UpdateGymSessionExerciseModel model);
}
