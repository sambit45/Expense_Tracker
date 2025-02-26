package com.authentication.authorization.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class RefreshTokenRequestDTO {
    private String token;


    public RefreshTokenRequestDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public RefreshTokenRequestDTO() {
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RefreshTokenRequestDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
