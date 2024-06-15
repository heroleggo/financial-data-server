package com.heroleggo.financial.rest.user.dto;

import com.heroleggo.financial.rest.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserCoreResponse {
    private String name;
    private String email;
    private String createdAt;

    public static UserCoreResponse of(User user) {
        return UserCoreResponse.builder()
            .name(user.getName())
            .email(user.getEmail())
            .createdAt(user.getCreatedAt().toString())
            .build();
    }
}
