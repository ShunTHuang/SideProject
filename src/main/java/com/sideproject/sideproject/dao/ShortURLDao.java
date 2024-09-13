package com.sideproject.sideproject.dao;

import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;

import java.util.List;

public interface ShortURLDao {
    ShortURL getShortURL(String shortURL);
    String createShortURL(ShortUrlRequest shortUrlRequest);
    List<ShortURL> getAllShortUrls(String userId);
}
