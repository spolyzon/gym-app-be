package com.gym.bodyandmindharmony.repositories;

import com.gym.bodyandmindharmony.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> { }
