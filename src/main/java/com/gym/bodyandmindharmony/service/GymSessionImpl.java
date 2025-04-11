package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.Client;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.models.NewGymSessionModel;
import com.gym.bodyandmindharmony.repositories.ClientRepository;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GymSessionImpl implements IGymSession {

    private final GymSessionRepository gymSessionRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<GymSession> getAllGymSessions() {
        return gymSessionRepository.findAll();
    }

    @Override
    public List<GymSession> getAllGymSessionsByUser(String username) {
        return clientRepository.findById(username)
                .map(Client::getGymSessions)
                .orElse(Collections.emptyList());
    }

    @Override
    public GymSession createNewGymSession(NewGymSessionModel newGymSessionModel) {
        GymSession gymSession = new GymSession();

        gymSession.setId(UUID.randomUUID().toString());
        gymSession.setStartTime(LocalDateTime.now());
        gymSession.setFinishTime(LocalDateTime.now());
//        gymSession.setClient(UUID.randomUUID().toString());

        return gymSessionRepository.saveAndFlush(gymSession);
    }
}
