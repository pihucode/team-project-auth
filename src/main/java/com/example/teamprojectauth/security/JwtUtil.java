package com.example.teamprojectauth.security;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Date;

public class JwtUtil {

    public static String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                //.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }
}

