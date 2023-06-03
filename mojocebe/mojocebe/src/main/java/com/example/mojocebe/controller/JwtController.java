package com.example.mojocebe.controller;

import com.example.mojocebe.utils.JwtUtils;
import com.example.mojocebe.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class JwtController {
    @GetMapping("/checkToken")
    public Result checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map map = JwtUtils.getMemberIdByJwtToken(token);
        return new Result().ok(map);
    }
}
