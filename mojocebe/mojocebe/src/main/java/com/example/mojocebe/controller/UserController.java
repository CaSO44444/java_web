package com.example.mojocebe.controller;

import ch.qos.logback.core.pattern.util.RestrictedEscapeUtil;
import com.example.mojocebe.entity.User;
import com.example.mojocebe.service.UserService;
import com.example.mojocebe.utils.JwtUtils;
import com.example.mojocebe.utils.Md5util;
import com.example.mojocebe.utils.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    public Result login(String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            Map map = new HashMap();
            String token = JwtUtils.getJwtToken(user.getId() + "", user.getUsername());
            map.put("token", token);
            map.put("username", username);
            return new Result<>().ok(map);
        }
        return new Result<>().error("用户名或密码不正确");
    }

    @PostMapping("/user/register")
    public Result register(String username, String password) {
        User user = userService.find(username);
        String Username = user.getUsername();
        if (!username.equals(Username)) {
            userService.register(username, password);
            return new Result<>().ok();
        }
        return new Result<>().error("用户名已存在");
    }
}
