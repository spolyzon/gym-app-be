package com.gym.bodyandmindharmony.controller;

import com.gym.bodyandmindharmony.api.GymSessionApi;
import com.gym.bodyandmindharmony.mapper.GymSessionMapper;
import com.gym.bodyandmindharmony.models.GymSessionModel;
import com.gym.bodyandmindharmony.models.NewGymSessionModel;
import com.gym.bodyandmindharmony.service.IGymSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<GymSessionModel>> retrieveGymSessions(@RequestParam String username) {
        if (StringUtils.isEmpty(username)) return ResponseEntity.ok(null);

        final var gymSessions = gymSessionService.getAllGymSessionsByUser(username)
                .stream()
                .map(mapper::mapToModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(gymSessions);
    }

    @PostMapping
    @Override
    public ResponseEntity<GymSessionModel> createNewGymSession(@RequestBody NewGymSessionModel newGymSessionModel,
                                                               @RequestParam String username) {
        final var persistedGymSession = gymSessionService.createNewGymSession(newGymSessionModel, username);
        final var model = mapper.mapToModel(persistedGymSession);

        return ResponseEntity.status(201).body(model);
    }
}
