package com.heroleggo.financial.rest.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "user_profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long id;

    @Comment("프로필사진 경로")
    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    @Comment("전화번호")
    @Column(name = "phone")
    private String phone;

    @Comment("주소지")
    @Column(name = "address")
    private String address;

    @Comment("직업군")
    @Column(name = "occupation")
    private String occupation;

    @Comment("자기소개")
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Comment("생년월일")
    @Column(name = "birth", columnDefinition = "DATE")
    private Date birth;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
