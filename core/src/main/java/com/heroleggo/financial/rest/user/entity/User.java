package com.heroleggo.financial.rest.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Comment("사용자 성명")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("사용자 이메일")
    @Column(name = "email", nullable = false)
    private String email;

    @Comment("사용자 암호화 비밀번호")
    @Column(name = "password", nullable = false)
    private String password;

    @Comment("생성일자")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public static User of(String name, String email) {
        return User.builder()
            .name(name)
            .email(email)
            .build();
    }
}
