package com.sideproject.sideproject.service.impl;

import com.sideproject.sideproject.dao.shortURLDao;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.shortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class shortURLServiceImpl implements shortURLService {

    @Autowired
    private shortURLDao shortURLDao;

    @Override
    public ShortURL getShortURL(String shortURL) {
        return shortURLDao.getShortURL(shortURL);
    }
}
