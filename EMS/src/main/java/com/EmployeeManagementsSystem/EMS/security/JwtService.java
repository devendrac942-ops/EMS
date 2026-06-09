package com.EmployeeManagementsSystem.EMS.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.SecretKey}")
    private String SecretKey;

    @Value("${jwt.expriation}")
    private Long jwtExpriation;

    private SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(SecretKey.getBytes());
    }

    public String generateToken(String userName){
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis()+jwtExpriation))
                .signWith(getSignInKey())
                .compact();
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token){
        return extractAllClaims(token)
                .getSubject();

    }

    private boolean isTokenExpried(String token){
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    public boolean isTokenValid(String token,String userEmail){
        String extractedEmail=extractUsername(token);

        return extractedEmail.equals(userEmail) && !isTokenExpried(token);
    }
}
