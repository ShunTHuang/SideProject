package com.sideproject.sideproject.service;

import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);
    User getUserById(Integer getUserById);
}
