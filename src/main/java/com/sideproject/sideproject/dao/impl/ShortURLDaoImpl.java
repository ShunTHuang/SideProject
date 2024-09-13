package com.sideproject.sideproject.dao.impl;

import com.sideproject.sideproject.dao.ShortURLDao;
import com.sideproject.sideproject.dto.ShortUrlRequest;
import com.sideproject.sideproject.generate.GenerateShortUrl;
import com.sideproject.sideproject.model.ShortURL;
import com.sideproject.sideproject.rowmapper.ShortURLRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ShortURLDaoImpl implements ShortURLDao {

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

    @Override
    public String createShortURL(ShortUrlRequest shortUrlRequest) {
        String shortURL = GenerateShortUrl.generateShortUrl(shortUrlRequest.getOriginalURL());
        if (getShortURL(shortURL) != null) {
            return getShortURL(shortURL).getShortURL();
        }

        String sql = "INSERT INTO shortURL (user_id, original, short, password, expired, created_date, last_modified_date) VALUES" +
                " (:user_id, :original, :short, :password, :expired, :created_date, :last_modified_date)";
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", shortUrlRequest.getUserId());
        params.put("original", shortUrlRequest.getOriginalURL());
        params.put("short", shortURL);

        if (shortUrlRequest.getExpiryDate().length() == 0) {
            params.put("expired", null);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss", Locale.US);
            try {
                Date date = formatter.parse(shortUrlRequest.getExpiryDate());
                params.put("expired", date);
            } catch (ParseException e) {
                e.printStackTrace();
                 params.put("expired", null);
            }
        }

        Date now = new Date();
        params.put("created_date", now);
        params.put("last_modified_date", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params), keyHolder);
        int id = keyHolder.getKey().intValue();
        if (id == 0) {
            return null;
        }

        return shortURL;
    }

    @Override
    public List<ShortURL> getAllShortUrls(String userId) {
        String sql = "select * from shortURL where user_id = :userId order by created_date DESC";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        List<ShortURL> shortURLList= namedParameterJdbcTemplate.query(sql, params, new ShortURLRowMapper());

        return shortURLList;
    }
}
