package com.online.taxi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt
 *
 * @author dongjb
 * @date 2018/08/15
 **/
public class JwtUtil {


    private static final String SECRET = "ko346134h_we]rg3in_yip1!";

    /**
     * 生成TOKEN
     *
     * @param subject   subject
     * @param issueDate 时间
     * @return string
     */
    public static String createJwt(String subject, Date issueDate) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 解密 jwt
     *
     * @param jwt 需要解密的字符串
     * @return Claims 对象
     */
    public static Claims parseJwt(String jwt) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody();
    }


}

