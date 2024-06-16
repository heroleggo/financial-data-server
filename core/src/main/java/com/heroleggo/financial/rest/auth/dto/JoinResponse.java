package com.heroleggo.financial.rest.auth.dto;

import com.heroleggo.financial.rest.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JoinResponse {
    private String name;
    private String email;
    private Long id;

    private String token;

    public static JoinResponse of(User user, String token) {
        return JoinResponse.builder()
            .name(user.getName())
            .email(user.getEmail())
            .id(user.getId())
            .token(token)
            .build();
    }
}
