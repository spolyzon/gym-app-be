package com.gym.bodyandmindharmony.controller;

import com.gym.bodyandmindharmony.models.GymUserLoginModel;
import com.gym.bodyandmindharmony.models.GymUserModel;
import com.gym.bodyandmindharmony.models.NewGymUserModel;
import com.gym.bodyandmindharmony.service.GymUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final GymUserService gymUserService;

    @PostMapping("/register")
    public ResponseEntity<GymUserModel> signup(@RequestBody NewGymUserModel newGymUserModel) {
        return ResponseEntity.status(CREATED).body(gymUserService.signup(newGymUserModel));
    }

    @PostMapping("/login")
    public ResponseEntity<GymUserModel> login(@RequestBody GymUserLoginModel gymUserLoginModel) {
        return ResponseEntity.ok(gymUserService.login(gymUserLoginModel));
    }
}
