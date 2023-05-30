package com.example.mojocebe.Interceptor;

import cn.hutool.http.Status;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.mojocebe.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 判断登陆
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
//            String token = request.getHeader("Authorization");
            String token = (String) request.getSession().getAttribute("Authorization");
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