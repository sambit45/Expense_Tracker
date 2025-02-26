package com.authentication.authorization.model;

import com.authentication.authorization.entities.UserInfo;
import com.authentication.authorization.entities.UserRole;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Set;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo {

    private String username;

    private String lastname;

    private Long phoneNumber;

    private String email;

    public UserInfoDto(String userId, String username, String password, Set<UserRole> roles) {
        super(userId, username, password, roles);
    }
}
