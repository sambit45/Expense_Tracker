package com.authentication.authorization.model;

import com.authentication.authorization.entities.UserInfo;
import com.authentication.authorization.entities.UserRole;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

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

    @Override
    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
