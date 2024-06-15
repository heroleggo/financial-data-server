package com.heroleggo.financial.rest.user.service;

import com.heroleggo.financial.rest.user.entity.User;
import com.heroleggo.financial.rest.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
