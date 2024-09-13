package com.sideproject.sideproject.service;

import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;

import java.util.List;

public interface ShortURLService {
    ShortURL getShortURL(String shortURL);
    String createShortURL(ShortUrlRequest shortUrlRequest);
    List<ShortURL> getAllShortURL(String userId);
}
