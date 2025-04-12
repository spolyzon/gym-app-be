package com.gym.bodyandmindharmony;

import com.gym.bodyandmindharmony.entities.Client;
import com.gym.bodyandmindharmony.entities.Exercise;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.ClientRepository;
import com.gym.bodyandmindharmony.repositories.ExerciseRepository;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BodyandmindharmonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodyandmindharmonyApplication.class, args);
	}

	@Bean
	CommandLineRunner setup(ClientRepository clientRepository, GymSessionRepository gymSessionRepository, ExerciseRepository exerciseRepository) {
		return x -> {
			Client spyros = new Client("spolyzon", LocalDateTime.now(), Collections.emptyList());
			Client test = new Client("test", LocalDateTime.now(), Collections.emptyList());
			clientRepository.saveAll(List.of(spyros, test));

			GymSession session1 = new GymSession(UUID.randomUUID().toString(), "push", LocalDateTime.now(), LocalDateTime.now(), spyros, new ArrayList<>(10));
//			GymSession session2 = new GymSession(UUID.randomUUID().toString(), "pull", LocalDateTime.now(), LocalDateTime.now(), spyros, new ArrayList<>(10));
//			GymSession session3 = new GymSession(UUID.randomUUID().toString(), "legs", LocalDateTime.now(), LocalDateTime.now(), spyros, new ArrayList<>(10));
//			GymSession session4 = new GymSession(UUID.randomUUID().toString(), "kykliko", LocalDateTime.now(), LocalDateTime.now(), spyros, new ArrayList<>(10));
//			GymSession session5 = new GymSession(UUID.randomUUID().toString(), "push", LocalDateTime.now(), LocalDateTime.now(), test, new ArrayList<>(10));
//			GymSession session6 = new GymSession(UUID.randomUUID().toString(), "pull", LocalDateTime.now(), LocalDateTime.now(), test, new ArrayList<>(10));
//			GymSession session7 = new GymSession(UUID.randomUUID().toString(), "legs", LocalDateTime.now(), LocalDateTime.now(), test, new ArrayList<>(10));
//			gymSessionRepository.saveAll(List.of(session1, session2, session3, session4, session5, session6, session7));
			gymSessionRepository.saveAll(List.of(session1));

			Exercise ex1 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);
//			Exercise ex2 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);
//			Exercise ex3 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);
//			Exercise ex4 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);
//			Exercise ex5 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);
//			Exercise ex6 = new Exercise(UUID.randomUUID().toString(), "Bench press", 2, 1.2, session1);

			exerciseRepository.saveAll(List.of(ex1));
		};
	}
}
