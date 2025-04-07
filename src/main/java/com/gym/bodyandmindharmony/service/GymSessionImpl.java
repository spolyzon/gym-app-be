package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GymSessionImpl implements IGymSession {

    private final GymSessionRepository gymSessionRepository;

    @Override
    public List<GymSession> getAllGymSessions() {
        return gymSessionRepository.findAll();
    }

    public void createGymSession(GymSession session) {
        gymSessionRepository.saveAndFlush(session);
    }
}
