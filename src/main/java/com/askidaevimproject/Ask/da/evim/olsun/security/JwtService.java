package com.askidaevimproject.Ask.da.evim.olsun.security;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Slf4j
@Service
public class JwtService {
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5275";
    private static final String TOKEN_ISSUER = "askidaEv";
    private static final int EXPIRE_HOURS = 10; // token expires in 10 hours


    public Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Member member) {
        return Jwts.builder()
                .signWith(getSigningKey())
                .setIssuer(TOKEN_ISSUER)
                .setSubject(member.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * EXPIRE_HOURS))
                .compact();
    }

    public Jws<Claims> verifyAuthHeader(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) return null;

        String token = authHeader.substring(7);

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
    }



}
