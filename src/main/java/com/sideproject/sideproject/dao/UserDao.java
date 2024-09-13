package com.sideproject.sideproject.dao;

import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer userId);
}
