package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import org.springframework.stereotype.Component;

@Component
public class MyGymSessionExerciseMapperImpl implements GymSessionExerciseMapper {

    @Override
    public GymExerciseSessionModel mapToModel(Exercise exercise) {
        final var model = new GymExerciseSessionModel();

        model.setId(exercise.getExerciseId());
        model.setName(exercise.getName());
        model.setRepetitions(exercise.getRepetitions());
        model.setWeight(exercise.getWeight());

        return model;
    }
}
