package com.heroleggo.financial.rest.user.service;

import com.heroleggo.financial.rest.user.entity.UserProfile;

public interface UserProfileService {
    public UserProfile getProfileByUserId(Long userId);
}
