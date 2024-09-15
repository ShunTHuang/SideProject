package com.sideproject.sideproject.service;

import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;

import java.util.List;

public interface ShortURLService {
    ShortURL getShortURL(String shortURL);
    ShortURL getShortURLByUserId(Integer userId, String shortURL);
    String createShortURL(Integer userId, ShortUrlRequest shortUrlRequest);
    List<ShortURL> getAllShortURL(String userId);
}
