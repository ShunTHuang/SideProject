package com.sideproject.sideproject.service.impl;

import com.sideproject.sideproject.dao.UserDao;
import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;
import com.sideproject.sideproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer getUserById) {
        return userDao.getUserById(getUserById);
    }
}
