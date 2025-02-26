package com.authentication.authorization.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JwtResponseDTO {

    private String accessToken;
    private String token;

    public JwtResponseDTO(String accessToken, String token) {
        this.accessToken = accessToken;
        this.token = token;
    }

    public JwtResponseDTO() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtResponseDTO{" +
                "accessToken='" + accessToken + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
