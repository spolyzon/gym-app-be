package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Exercise;

import java.util.List;

public interface IGymSessionExercise {

    List<Exercise> getAllExercises(String gymSessionId);
}
