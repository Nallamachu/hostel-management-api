package com.msts.hostel.util;

import com.msts.hostel.document.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

public class JwtTokenGenerator {

    public static String generateToken(User u, String secret) {
        Claims claims = Jwts.claims().setSubject(u.getMobile());
        claims.put("role", u.getType());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(DateTime.now().plusSeconds(30).toDate())
                .compact();
    }
}