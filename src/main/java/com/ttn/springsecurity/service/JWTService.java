package com.ttn.springsecurity.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private final int expireTime = 120000;
    private String secret = "deepanshusocoolsocoolsocoolsocool";

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret.repeat(10));
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ expireTime))
                .subject(username)
                .and()
                .signWith(getSecretKey(), Jwts.SIG.HS512)
                .compact();
    }

    public String extractUsername(String jwt) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String jwt, String username) {
        final String extractedUsername = extractUsername(jwt);
        return (extractedUsername.equals(username) && !isTokenExpired(jwt));
    }

    public boolean isTokenExpired(String jwt){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getExpiration()
                .before(new Date());
    }
}

