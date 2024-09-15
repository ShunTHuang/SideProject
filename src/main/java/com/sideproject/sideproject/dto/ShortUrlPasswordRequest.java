package com.sideproject.sideproject.dto;

import jakarta.validation.constraints.NotNull;

public class ShortUrlPasswordRequest {
    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
