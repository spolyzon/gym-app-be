package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.GymUser;
import com.gym.bodyandmindharmony.exception.DuplicateUsernameException;
import com.gym.bodyandmindharmony.exception.UserNotFoundException;
import com.gym.bodyandmindharmony.models.GymUserLoginModel;
import com.gym.bodyandmindharmony.models.GymUserModel;
import com.gym.bodyandmindharmony.models.NewGymUserModel;
import com.gym.bodyandmindharmony.repositories.GymUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GymUserService {

    private final GymUserRepository gymUserRepository;
    private final JwtService jwtService;

    public GymUserModel signup(NewGymUserModel newGymUserModel) {
        log.info("Registering new User: " + newGymUserModel);
        final var optGymUser = gymUserRepository.findByUsername(newGymUserModel.getUsername());

        if (optGymUser.isPresent()) throw new DuplicateUsernameException();

        final var gymUser = gymUserRepository.saveAndFlush(mapToGymUser(newGymUserModel));

        return GymUserModel.builder()
                .firstName(gymUser.getFirstName())
                .lastName(gymUser.getLastName())
                .username(gymUser.getUsername())
                .accessToken(jwtService.generateAccessToken(gymUser.getUsername()))
                .refreshToken(jwtService.generateRefreshToken(gymUser.getUsername()))
                .build();
    }

    public GymUserModel login(GymUserLoginModel gymUserLoginModel) {
        log.info("Logging in User: " + gymUserLoginModel);

        final var gymUser = gymUserRepository.findByUsername(gymUserLoginModel.getUsername())
                .orElseThrow(() -> new UserNotFoundException(gymUserLoginModel.getUsername()));

        return GymUserModel.builder()
                .firstName(gymUser.getFirstName())
                .lastName(gymUser.getLastName())
                .username(gymUser.getUsername())
                .accessToken(jwtService.generateAccessToken(gymUser.getUsername()))
                .refreshToken(jwtService.generateRefreshToken(gymUser.getUsername()))
                .build();
    }

    private GymUser mapToGymUser(NewGymUserModel newGymUserModel) {
        return GymUser.builder()
                .username(newGymUserModel.getUsername())
                .firstName(newGymUserModel.getFirstName())
                .lastName(newGymUserModel.getLastName())
                .build();
    }
}
