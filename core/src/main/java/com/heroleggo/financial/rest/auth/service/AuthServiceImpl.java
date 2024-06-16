package com.heroleggo.financial.rest.auth.service;

import com.heroleggo.financial.rest.auth.dto.JoinRequest;
import com.heroleggo.financial.rest.user.entity.User;
import com.heroleggo.financial.rest.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements UserDetailsService, AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .roles("USER")
            .build();
    }

    @Transactional
    public User join(JoinRequest request) {
        User newUser = User.of(request.getName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));

        return userRepository.save(newUser);
    }
}
