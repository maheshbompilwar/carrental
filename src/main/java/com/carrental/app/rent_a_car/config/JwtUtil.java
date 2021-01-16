package com.carrental.app.rent_a_car.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtUtil {
    private String secret;
    private int jwtExpirationInMs;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }
    @Value("${jwt.jwtExpirationInMs}")
    public void setJwtExpirationInMs(int jwtExpirationInMs) {
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims =  new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        System.out.println("===================In Generate Token ===================="+roles);
        if(roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            claims.put("isAdmin",true);
            System.out.println("===================ROLE ADMIN====================");
        }
        if(roles.contains(new SimpleGrantedAuthority("ROLE_USER"))){
            claims.put("isUser",true);
            System.out.println("===================ROLE USER====================");
        }

        return doGenerateToken(claims,userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        return Jwts.builder().setClaims(claims).setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public boolean validateToken(String authToken){
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        }catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex){
            throw new BadCredentialsException("INVALID_CREDENTIALS",ex);
        } catch (ExpiredJwtException ex){
            throw ex;
        }
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        List<SimpleGrantedAuthority> roles = null;

        Boolean isAdmin = claims.get("isAdmin", Boolean.class);
        Boolean isUser = claims.get("isUser",Boolean.class);

        System.out.println("----------isAdmin-------"+isAdmin);
        System.out.println("-----------isUser------"+isUser);

        if(isAdmin != null && isAdmin){
            roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(isUser != null && isUser){
            roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return roles;
    }
}