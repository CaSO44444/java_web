package com.example.mojocebe.utils;

import cn.hutool.http.Status;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    // 签名哈希的密钥，对于不同的加密算法来说含义不同
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 根据用户id和昵称生成token
     * @param id  用户id
     * @param name 用户昵称
     * @return JWT规则生成的token
     */
    public static String getJwtToken(String id, String name, String roles){
        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("baobao-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("name", name)
                .claim("roles", roles)
                // HS256算法实际上就是MD5加盐值，此时APP_SECRET就代表盐值
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken token字符串
     * @return 如果token有效返回true，否则返回false
     */
    public static int checkToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            return Status.HTTP_FORBIDDEN;
        }
        return Status.HTTP_ACCEPTED;
    }

    /**
     * 根据token获取会员id
     * @return 解析token后获得的用户id
     */
    public static Map<String,Object> getMemberIdByJwtToken(String jwtToken) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        Map<String,Object> map = new HashMap();
        map.put("id",claims.get("id"));
        map.put("name",claims.get("name"));
        map.put("roles",claims.get("roles"));
        return map;
    }
}
