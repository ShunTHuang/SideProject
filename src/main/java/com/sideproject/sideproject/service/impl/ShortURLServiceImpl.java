package com.sideproject.sideproject.service.impl;

import com.sideproject.sideproject.dao.ShortURLDao;
import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShortURLServiceImpl implements ShortURLService {

    @Autowired
    private ShortURLDao shortURLDao;

    @Override
    public ShortURL getShortURL(String shortURL) {
        return shortURLDao.getShortURL(shortURL);
    }

    @Override
    public String createShortURL(ShortUrlRequest shortUrlRequest) {
        return shortURLDao.createShortURL(shortUrlRequest);
    }

    @Override
    public List<ShortURL> getAllShortURL(String userId) {
        return shortURLDao.getAllShortUrls(userId);
    }
}
