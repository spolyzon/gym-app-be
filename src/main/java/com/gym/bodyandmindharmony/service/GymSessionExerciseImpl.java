package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.ExerciseRepository;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GymSessionExerciseImpl implements IGymSessionExercise {

    private final GymSessionRepository gymSessionRepository;
    private final ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercises(String gymSessionId) {
        return gymSessionRepository.findById(gymSessionId)
                .map(GymSession::getExerciseList)
                .orElse(Collections.emptyList());
    }

    @Override
    public void addExercise(String gymSessionId, Exercise newExercise) {
        final var gymSession = gymSessionRepository.findById(gymSessionId).orElseThrow();
        newExercise.setGymSession(gymSession);
        gymSession.getExerciseList().add(newExercise);
        gymSessionRepository.saveAndFlush(gymSession);
    }
}
