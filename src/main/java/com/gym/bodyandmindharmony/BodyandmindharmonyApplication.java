package com.gym.bodyandmindharmony;

import com.gym.bodyandmindharmony.entities.Client;
import com.gym.bodyandmindharmony.entities.GymSession;
import com.gym.bodyandmindharmony.repositories.ClientRepository;
import com.gym.bodyandmindharmony.repositories.GymSessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BodyandmindharmonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BodyandmindharmonyApplication.class, args);
	}

	@Bean
	CommandLineRunner setup(ClientRepository clientRepository, GymSessionRepository gymSessionRepository) {
		return x -> {
			Client spyros = new Client("spolyzon", LocalDateTime.now(), Collections.emptyList());
			Client test = new Client("test", LocalDateTime.now(), Collections.emptyList());
			clientRepository.saveAll(List.of(spyros, test));

			GymSession session1 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), spyros, Collections.emptyList());
			GymSession session2 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), spyros, Collections.emptyList());
			GymSession session3 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), spyros, Collections.emptyList());
			GymSession session4 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), spyros, Collections.emptyList());
			GymSession session5 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), test, Collections.emptyList());
			GymSession session6 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), test, Collections.emptyList());
			GymSession session7 = new GymSession(UUID.randomUUID().toString(), LocalDateTime.now(), LocalDateTime.now(), test, Collections.emptyList());
			gymSessionRepository.saveAll(List.of(session1, session2, session3, session4, session5, session6, session7));
		};
	}
}
