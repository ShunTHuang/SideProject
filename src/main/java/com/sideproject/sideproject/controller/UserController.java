package com.sideproject.sideproject.controller;

import com.sideproject.sideproject.dto.UserLoginRequest;
import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;
import com.sideproject.sideproject.service.UserService;
import com.sideproject.sideproject.util.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping("/users/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        User user =  userService.login(userLoginRequest);

        String token = tokenUtil.getToken(user.getUserId(), user.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
