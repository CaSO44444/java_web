package com.example.mojocebe.Interceptor;

import cn.hutool.http.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.mojocebe.utils.JwtUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    private String token = "";
    /**
     * 判断登陆
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for(Cookie cookie : cookies){
                    if (cookie.getName().equals("token")){
                        token = cookie.getValue();
                        break;
                    }
                }
            }

            int result = JwtUtils.checkToken(token);
            if (result == Status.HTTP_FORBIDDEN) {
                response.setStatus(401);
                return false;
            }
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
}