package com.sideproject.sideproject.service.impl;

import com.sideproject.sideproject.dao.ShortURLDao;
import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class ShortURLServiceImpl implements ShortURLService {

    @Autowired
    private ShortURLDao shortURLDao;

    @Override
    public ShortURL getShortURL(String shortURL) {
        ShortURL s = shortURLDao.getShortURL(shortURL);
        if (s.getPassword() != null) {
            s.setRequirePassword(true);
        } else {
            s.setRequirePassword(false);
        }
        return s;
    }

    @Override
    public ShortURL getShortURLByUserId(Integer userId, String shortURL) {
        ShortURL s = shortURLDao.getShortURLByUserId(userId, shortURL);
        if (s.getPassword() != null) {
            s.setRequirePassword(true);
        } else {
            s.setRequirePassword(false);
        }

        return s;
    }

    @Override
    public ShortURL getShortURLByUserIdPassword(Integer userId, String shortURL, String password) {
        ShortURL shortURLDetail = shortURLDao.getShortURLByUserId(userId, shortURL);
        String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!hashPassword.equals(shortURLDetail.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
        }
        return shortURLDetail;
    }

    @Override
    public String createShortURL(Integer userId, ShortUrlRequest shortUrlRequest) {
        return shortURLDao.createShortURL(userId, shortUrlRequest);
    }

    @Override
    public List<ShortURL> getAllShortURL(String userId) {
        List<ShortURL> urlList = shortURLDao.getAllShortUrls(userId);
        for (ShortURL shortURL : urlList) {
            if (shortURL.getPassword() != null) {
                shortURL.setRequirePassword(true);
            } else {
                shortURL.setRequirePassword(false);
            }
        }
        return urlList;
    }
}
