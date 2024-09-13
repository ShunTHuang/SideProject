package com.sideproject.sideproject.service.impl;

import com.sideproject.sideproject.dao.UserDao;
import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;
import com.sideproject.sideproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if (user != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer getUserById) {
        return userDao.getUserById(getUserById);
    }
}
