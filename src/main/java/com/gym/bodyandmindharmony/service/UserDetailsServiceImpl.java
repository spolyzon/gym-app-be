package com.gym.bodyandmindharmony.service;

import com.gym.bodyandmindharmony.entities.GymUser;
import com.gym.bodyandmindharmony.repositories.GymUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final GymUserRepository gymUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var gymUser = getUser(username);

        return buildUser(gymUser);
    }

    private GymUser getUser(String username) {
        return gymUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User does not exist: " + username));
    }

    private UserDetails buildUser(GymUser gymUser) {
        return User.withUsername(gymUser.getUsername())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
