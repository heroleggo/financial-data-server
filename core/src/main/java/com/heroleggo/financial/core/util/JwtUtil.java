package com.heroleggo.financial.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    @Value("${jwt.secretKey}")
    private String secretKey;
    private static final long EXPIRATION_DATE = 1000 * 60 * 60 * 24; // 1 Day (1000ms * 60 second * 60 min * 24 hour)

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email) {
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
            .signWith(getSigningKey())
            .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isTokenExpired(String token) {
        return extractClaims(token)
            .getExpiration()
            .before(new Date());
    }

    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }
}
