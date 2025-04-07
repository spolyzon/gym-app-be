package com.gym.bodyandmindharmony.repositories;

import com.gym.bodyandmindharmony.entities.GymSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymSessionRepository extends JpaRepository<GymSession, String> {
}
