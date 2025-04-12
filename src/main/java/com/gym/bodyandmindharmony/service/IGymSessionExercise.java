package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Exercise;

import java.util.List;

public interface IGymSessionExercise {

    List<Exercise> getAllExercises(String gymSessionId);

    void addExercise(String gymSessionId, Exercise newExercise);

    void updateExercise(String gymSessionId, Exercise updateExercise);

    void deleteExercise(String exerciseId);
}
