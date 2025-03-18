package com.expensetracker.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {

    Long id;

    @Id
    private String userId;

    private String firstName;

    private String lastName;

    private Long phoneNumber;

    private String email;

    private String profilePic;

    public UserInfoDto() {
    }

    public UserInfoDto(Long id, String userId, String firstName, String lastName, Long phoneNumber, String email, String profilePic) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profilePic = profilePic;
    }

}
