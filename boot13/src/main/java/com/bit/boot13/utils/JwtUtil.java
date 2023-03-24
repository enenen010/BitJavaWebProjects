package com.bit.boot13.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	@Value("${sec.key}") //아래꺼안쓰고 전달받고싶을때
	String key = "abcdefghabcdefghabcdefghabcdefgh";
	
	public Jws<Claims> getJwt(String compactJws) {
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
		try {
			return Jwts.parserBuilder().setSigningKey(secretKey)
					.build().parseClaimsJws(compactJws); 
		} catch (JwtException e) {

		    //don't trust the JWT!
		}
		return null;
	}
	
	
	public String getJwtName(String compactJws) {
		return getJwt(compactJws)==null
				?null
				:(String)getJwt(compactJws).getBody().get("ename");
		
	}
	//토큰 발급
	//토큰을 발급할때 리프레쉬는 limit 길게 하나는 짧게
	public String createJwt(String name,long limit) {
		
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
		
		String jws = Jwts.builder()
				.setSubject("BOb")
				.claim("ename", name)
				.setExpiration(new Date(System.currentTimeMillis()+limit))
				.signWith(secretKey,SignatureAlgorithm.HS256)
				.compact();
		return jws;
	}
	public String createJwt() {
		return createJwt("tester", 100*60);
	}
}
