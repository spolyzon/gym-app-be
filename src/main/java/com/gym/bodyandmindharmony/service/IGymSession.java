package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.models.NewGymSessionModel;

import java.util.List;

public interface IGymSession {

    List<GymSession> getAllGymSessions();

    GymSession createNewGymSession(NewGymSessionModel newGymSessionModel);
}
