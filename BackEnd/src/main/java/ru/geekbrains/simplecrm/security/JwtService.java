package ru.geekbrains.simplecrm.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtService {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    public UserInfo getUserInfo(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        String subject = claims.getSubject();
        Long id = claims.get("id", Long.class);
        String authorities = claims.get("authorities", String.class);
        UserInfo userInfo = new UserInfo(id, subject, authorities);
        return userInfo;
    }

    public String generateToken(UserInfo userInfo) {
        Instant expirationTime = Instant.now().plus(1, ChronoUnit.HOURS);
        Date expirationDate = Date.from(expirationTime);
        String token = Jwts.builder()
                .claim("id", userInfo.getId())
                .claim("authorities", userInfo.getAuthorities())
                .setSubject(userInfo.getLogin())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
        return "Bearer " + token;
    }
}
