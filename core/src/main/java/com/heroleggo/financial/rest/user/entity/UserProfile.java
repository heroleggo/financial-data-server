package com.heroleggo.financial.rest.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {
    @Id
    @Column(name = "user_profile_id", columnDefinition = "AUTO_INCREMENT")
    private Long id;

    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "birth", columnDefinition = "DATE")
    private Date birth;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
