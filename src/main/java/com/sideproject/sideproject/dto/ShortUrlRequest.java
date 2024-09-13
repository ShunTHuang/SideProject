package com.sideproject.sideproject.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ShortUrlRequest {

    private Integer userId;

    @NotNull
    private String originalURL;

    private String password;
    private String expiryDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
