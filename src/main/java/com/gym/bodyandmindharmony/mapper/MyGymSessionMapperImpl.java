package com.gym.bodyandmindharmony.mapper;

import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.models.GymSessionModel;
import org.springframework.stereotype.Component;

@Component
public class MyGymSessionMapperImpl implements GymSessionMapper {

    @Override
    public GymSessionModel mapToModel(GymSession entity) {
        return new GymSessionModel(entity.getId(), entity.getFinishTime().toLocalDate(), "default");
    }
}
