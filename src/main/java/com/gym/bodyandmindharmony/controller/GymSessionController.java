package com.gym.bodyandmindharmony.controller;

import com.gym.bodyandmindharmony.api.GymSessionApi;
import com.gym.bodyandmindharmony.mapper.GymSessionMapper;
import com.gym.bodyandmindharmony.models.GymSessionModel;
import com.gym.bodyandmindharmony.service.IGymSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class GymSessionController implements GymSessionApi {

    private final IGymSession gymSessionService;
    private final GymSessionMapper mapper;

    @GetMapping
    @Override
    public ResponseEntity<List<GymSessionModel>> retrieveAllGymSessions() {
        final var gymSessions = gymSessionService.getAllGymSessions()
                .stream()
                .map(mapper::mapToModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(gymSessions);
    }
}
