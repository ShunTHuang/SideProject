package com.sideproject.sideproject.dao.impl;

import com.sideproject.sideproject.dao.UserDao;
import com.sideproject.sideproject.dto.UserRegisterRequest;
import com.sideproject.sideproject.model.User;
import com.sideproject.sideproject.rowmapper.ShortURLRowMapper;
import com.sideproject.sideproject.rowmapper.UserRollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        String sql = "INSERT INTO user (email, password, created_date, last_modified_date) VALUES" +
                " (:email, :password, :created_date, :last_modified_date)";
        Map<String, Object> params = new HashMap<>();
        params.put("email", userRegisterRequest.getEmail());
        params.put("password", userRegisterRequest.getPassword());

        Date now = new Date();
        params.put("created_date", now);
        params.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params), keyHolder);
        int userId = keyHolder.getKey().intValue();

        return userId;
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "select * from user where user_id = :userId";

        Map<String, Object> params = new HashMap<>();;
        params.put("userId", userId);
        List<User> userList= namedParameterJdbcTemplate.query(sql, params, new UserRollMapper());

        if (userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
                String sql = "select * from user where email = :email";

        Map<String, Object> params = new HashMap<>();;
        params.put("email", email);
        List<User> userList= namedParameterJdbcTemplate.query(sql, params, new UserRollMapper());

        if (userList.size()>0){
            return userList.get(0);
        }
        return null;
    }
}
