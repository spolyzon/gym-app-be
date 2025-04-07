package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.models.GymSessionModel;

public interface GymSessionMapper {

    GymSessionModel mapToModel(GymSession entity);
}
