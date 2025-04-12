package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GymSessionExerciseImpl implements IGymSessionExercise {

    private final GymSessionRepository gymSessionRepository;

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

    @Override
    public void updateExercise(String gymSessionId, Exercise updateExercise) {
        final var gymSession = gymSessionRepository.findById(gymSessionId).orElseThrow();
        final var exercise = gymSession.getExerciseList().stream()
                .filter(ex -> updateExercise.getExerciseId().equals(ex.getExerciseId()))
                .findFirst().orElseThrow();

        Optional.ofNullable(updateExercise.getName()).ifPresent(exercise::setName);
        Optional.ofNullable(updateExercise.getRepetitions()).ifPresent(exercise::setRepetitions);
        Optional.ofNullable(updateExercise.getWeight()).ifPresent(exercise::setWeight);

        gymSessionRepository.saveAndFlush(gymSession);
    }
}
