package com.sideproject.sideproject.dao.impl;

import com.sideproject.sideproject.dao.shortURLDao;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.rowmapper.ShortURLRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class shortURLDaoImpl implements shortURLDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ShortURL getShortURL(String shortURL) {
        String sql = "select * from shortURL where short = :shortURL";

        Map<String, Object> params = new HashMap<>();;
        params.put("shortURL", shortURL);
        List<ShortURL> shortURLList= namedParameterJdbcTemplate.query(sql, params, new ShortURLRowMapper());

        if(shortURLList.size()>0){
            return shortURLList.get(0);
        }
        return null;
    }
}
