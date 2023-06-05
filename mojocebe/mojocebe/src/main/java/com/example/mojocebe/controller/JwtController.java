package com.example.mojocebe.controller;

import com.example.mojocebe.utils.JwtUtils;
import com.example.mojocebe.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class JwtController {
    private String token;
    @GetMapping("/checkToken")
    public Result checkToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for(Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        Map map = JwtUtils.getMemberIdByJwtToken(token);
        return new Result().ok(map);
    }
}
