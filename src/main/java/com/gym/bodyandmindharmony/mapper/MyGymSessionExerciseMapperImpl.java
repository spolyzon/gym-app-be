package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionExerciseModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

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

    @Override
    public Exercise mapToNewEntity(NewGymSessionExerciseModel model) {
        final var newExercise = new Exercise();

        newExercise.setExerciseId(UUID.randomUUID().toString());
        newExercise.setName(model.getName());
        newExercise.setRepetitions(model.getRepetitions());
        newExercise.setWeight(model.getWeight());

        return newExercise;
    }
}
