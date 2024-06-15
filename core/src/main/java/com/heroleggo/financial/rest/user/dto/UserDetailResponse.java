package com.heroleggo.financial.rest.user.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data()
public class UserDetailResponse extends UserCoreResponse {
    private String profilePicturePath;
    private String phone;
    private String address;
    private String occupation;
    private String bio;
    private Date birth;
}
