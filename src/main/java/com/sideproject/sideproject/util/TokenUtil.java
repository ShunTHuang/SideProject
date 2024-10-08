package com.sideproject.sideproject.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    public String getToken(Integer userId, String userMail) {
        String token = JWT.create()
                .withClaim("userId", userId.toString())
                .withClaim("userMail", userMail)
                .sign(Algorithm.HMAC256("secretKey"));

        return token;
    }

    public Map<String, String> parseToken(String token) {
        Map<String, String> map = new HashMap<>();
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256("secretKey")).build().verify(token);
        Claim userId = jwt.getClaim("userId");
        Claim userMail = jwt.getClaim("userMail");
        map.put("userId", userId.asString());
        map.put("userMail", userMail.asString());
        return map;
    }

    public Boolean isTokenValid(String userId, String token) {
        Map<String, String> userInfo = parseToken(token);
        if (!userInfo.get("userId").equals(userId)) return false;
        return true;
    }
}
