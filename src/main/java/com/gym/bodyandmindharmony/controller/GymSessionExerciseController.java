package com.gym.bodyandmindharmony.controller;

import com.gym.bodyandmindharmony.api.GymSessionExerciseApi;
import com.gym.bodyandmindharmony.mapper.GymSessionExerciseMapper;
import com.gym.bodyandmindharmony.models.GymExerciseSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionExerciseModel;
import com.gym.bodyandmindharmony.service.IGymSessionExercise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercises")
public class GymSessionExerciseController implements GymSessionExerciseApi {

    private final IGymSessionExercise gymSessionExercise;
    private final GymSessionExerciseMapper mapper;

    @GetMapping("/{gymSessionId}")
    @Override
    public ResponseEntity<List<GymExerciseSessionModel>> getAllExercises(@PathVariable String gymSessionId) {
        final var exercises = gymSessionExercise.getAllExercises(gymSessionId)
                .stream()
                .map(mapper::mapToModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exercises);
    }

    @PostMapping("/{gymSessionId}")
    public ResponseEntity<Void> addExercise(@PathVariable String gymSessionId,
                                            @RequestBody NewGymSessionExerciseModel newGymSessionExerciseModel) {
        gymSessionExercise.addExercise(gymSessionId, mapper.mapToNewEntity(newGymSessionExerciseModel));
        return ResponseEntity.status(201).build();
    }
}
