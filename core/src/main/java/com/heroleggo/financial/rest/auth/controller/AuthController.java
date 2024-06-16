package com.heroleggo.financial.rest.auth.controller;

import com.heroleggo.financial.core.util.JwtUtil;
import com.heroleggo.financial.rest.auth.dto.JoinRequest;
import com.heroleggo.financial.rest.auth.dto.JoinResponse;
import com.heroleggo.financial.rest.auth.dto.LoginRequest;
import com.heroleggo.financial.rest.auth.dto.LoginResponse;
import com.heroleggo.financial.rest.auth.service.AuthService;
import com.heroleggo.financial.rest.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody JoinRequest request) {
        User newUser = authService.join(request);

        String token = jwtUtil.generateToken(newUser.getEmail());

        return ResponseEntity.ok(JoinResponse.of(newUser, token));
    }
}
