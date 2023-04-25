package com.example.mojocebe.Interceptor;

import cn.hutool.http.Status;
import com.example.mojocebe.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = request.getHeader("Authorization");
            int result = JwtUtils.checkToken(token);
            if (result == Status.HTTP_FORBIDDEN) {
                response.setStatus(401);
                return false;
            }
            else{
                Map role_map = JwtUtils.getMemberIdByJwtToken(token);
                Integer role = Integer.parseInt((String) role_map.get("roles"));
                if (role == 0){
                    response.setStatus(401);
                    return false;
                }
                return true;
            }
//            return true;
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}