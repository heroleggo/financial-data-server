package com.heroleggo.financial.rest.auth.service;

import com.heroleggo.financial.rest.auth.dto.JoinRequest;
import com.heroleggo.financial.rest.user.entity.User;


public interface AuthService {
    public User join(JoinRequest request);
}
