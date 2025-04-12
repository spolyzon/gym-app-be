package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class GymSessionExerciseImpl implements IGymSessionExercise {

    private final GymSessionRepository gymSessionRepository;

    @Override
    public List<Exercise> getAllExercises(String gymSessionId) {
        return gymSessionRepository.findById(gymSessionId)
                .map(GymSession::getExerciseList)
                .orElse(Collections.emptyList());
    }
}
