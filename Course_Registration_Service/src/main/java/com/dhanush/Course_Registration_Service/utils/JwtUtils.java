package com.dhanush.Course_Registration_Service.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtils {
    private final String SECRET="secret";

    public String generateJwt(UserDetails uDetails){
        Map<String,Object> claims=new HashMap<>();
        return createJwt(uDetails,claims);
    }

    private String createJwt(UserDetails uDetails, Map<String,Object> claims){
        return Jwts.builder().setClaims(claims).setSubject(uDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
            .signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }

    public Boolean validateToken(String jwt,UserDetails userDetails){
        String userName=extractUserName(jwt);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(jwt);
            
    }

    private Boolean isTokenExpired(String jwt){
        return extractExpration(jwt).before(new Date());
    }

    public Date extractExpration(String jwt){
        return extractClaims(jwt, Claims::getExpiration);
    }

    private String extractUserName(String jwt){
        return extractClaims(jwt,Claims::getSubject);
    }

    private <I> I extractClaims(String jwt,Function<Claims,I> claimsResolver){
        Claims claims=extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwt){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody();
    }
}
