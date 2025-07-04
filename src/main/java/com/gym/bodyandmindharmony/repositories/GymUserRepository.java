package com.gym.bodyandmindharmony.repositories;

import com.gym.bodyandmindharmony.entities.GymUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long> {
    Optional<GymUser> findByUsername(String username);
}
