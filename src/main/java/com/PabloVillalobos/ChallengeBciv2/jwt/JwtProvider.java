package com.PabloVillalobos.ChallengeBciv2.jwt;


import java.util.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.PabloVillalobos.ChallengeBciv2.User.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;



@Component
public class JwtProvider {
	@Value("${jwt.secret}")
	private String secret;
	
	@PostConstruct
	protected void init() {
		secret = Base64.getEncoder().encodeToString(secret.getBytes());
	}
	
	public String createToken(UserEntity user) {
		Map<String, Object> claims = new HashMap<>();
		claims = Jwts.claims().setSubject(user.getId());
		claims.put("id", user.getId());
		claims.put("email", user.getEmail());
		claims.put("isActive", user.getIsActive());
		claims.put("created",user.getCreated());
		Date now = new Date();
		Date exp = new Date(now.getTime()+ 3600000);
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean validate(String token) {
		
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
	
	
	public String getUserIdFromToken(String token) {
		try {
			return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
		} catch (Exception e) {
			return "Bad Token";
		}
	}
	
	
}
