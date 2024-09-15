package com.sideproject.sideproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class ShortURL {

    @JsonIgnore
    private Integer shortURLId;
    @JsonIgnore
    private Integer userId;
    private String originalURL;
    private String shortURL;
    private String password;
    private Date expiryDate;
    private Date createdDate;
    private Date modifiedDate;

    public Integer getShortURLId() {
        return shortURLId;
    }

    public void setShortURLId(Integer shortURLId) {
        this.shortURLId = shortURLId;
    }

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

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
