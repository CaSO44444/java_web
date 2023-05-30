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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    public Result login(String username, String password, String verifyCode, HttpServletRequest httpServletRequest) {
        if (verifyCode.equals(httpServletRequest.getSession().getAttribute("verifyCode"))){
            User user = userService.login(username, password);
            if (user != null) {
                Map map = new HashMap();
                String token = JwtUtils.getJwtToken(user.getId() + "", user.getUsername(), user.getRoles() + "");
                map.put("token", token);
                map.put("username", username);
                map.put("role",user.getRoles());
                httpServletRequest.getSession().setAttribute("Authorization", token);
                return new Result<>().ok(map);
            }
            return new Result<>().error("用户名或密码不正确");
        }
        return new Result<>().error("验证码错误");
    }

    @PostMapping("/user/register")
    public Result register(String username, String password, String check_password, String verifyCode, Integer roles, HttpServletRequest httpServletRequest) {
        User user = userService.find(username);
        if (user == null){
            HttpSession session = httpServletRequest.getSession();
            String kaptchaCode = session.getAttribute("verifyCode") + "";
            System.out.println(kaptchaCode);
            if(verifyCode.equals(kaptchaCode)){
                if (password.equals(check_password)){
                    userService.register(username, password, roles);
                    return new Result<>().ok();
                }else{
                    return new Result<>().error("两次输入密码不一致");
                }
            }else {
                return new Result<>().error("验证码错误");
            }
        }
//        }
        return new Result<>().error("用户名已存在");
    }
}
