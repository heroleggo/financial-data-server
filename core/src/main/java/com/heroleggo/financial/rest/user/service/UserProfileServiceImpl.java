package com.heroleggo.financial.rest.user.service;

import com.heroleggo.financial.rest.user.entity.UserProfile;
import com.heroleggo.financial.rest.user.repository.UserProfileRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public UserProfile getProfileByUserId(Long userId) {
        Optional<UserProfile> profile = userProfileRepository.findByUser_Id(userId);
        return profile.orElse(null);
    }
}
