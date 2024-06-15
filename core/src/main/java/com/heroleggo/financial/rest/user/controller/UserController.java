package com.heroleggo.financial.rest.user.controller;

import com.heroleggo.financial.rest.user.dto.UserCoreResponse;
import com.heroleggo.financial.rest.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public UserCoreResponse getUserInfo() {}
}
