package com.example.mojocebe.Interceptor;


import cn.hutool.http.Status;
import com.example.mojocebe.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class PatientInterceptor implements HandlerInterceptor {
    private String token = "";
    /**
     * 针对Patient的拦截器，医生不能访问的路由在webconfig配置
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
            else{
                Map role_map = JwtUtils.getMemberIdByJwtToken(token);
                Integer role = Integer.parseInt((String) role_map.get("roles"));
                if (role == 2){
                    response.setStatus(401);
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}