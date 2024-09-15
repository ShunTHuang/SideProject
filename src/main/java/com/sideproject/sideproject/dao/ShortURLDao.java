package com.sideproject.sideproject.dao;

import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;

import java.util.List;

public interface ShortURLDao {
    ShortURL getShortURL(String shortURL);
    ShortURL getShortURLByUserId(Integer userId, String shortURL);
    String createShortURL(Integer userId, ShortUrlRequest shortUrlRequest);
    List<ShortURL> getAllShortUrls(String userId);
}
