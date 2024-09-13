package com.sideproject.sideproject.rowmapper;

import com.sideproject.sideproject.model.ShortURL;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortURLRowMapper implements RowMapper<ShortURL> {
    @Override
    public ShortURL mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShortURL shortURL = new ShortURL();
        shortURL.setShortURLId(rs.getInt("shortURL_id"));
        shortURL.setUserId(rs.getInt("user_id"));
        shortURL.setOriginalURL(rs.getString("original"));
        shortURL.setShortURL(rs.getString("short"));
        shortURL.setPassword(rs.getString("password"));
        shortURL.setExpiryDate(rs.getTimestamp("expired"));
        shortURL.setCreatedDate(rs.getTimestamp("created_date"));
        shortURL.setModifiedDate(rs.getTimestamp("last_modified_date"));
        return shortURL;
    }
}
