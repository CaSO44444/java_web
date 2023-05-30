package com.example.mojocebe.Interceptor;

import cn.hutool.http.Status;
import com.example.mojocebe.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class DoctorInterceptor implements HandlerInterceptor {

    /**
     * 针对Doctor的拦截器，医生不能访问的路由在webconfig配置
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
            else{
                Map role_map = JwtUtils.getMemberIdByJwtToken(token);
                Integer role = Integer.parseInt((String) role_map.get("roles"));
                if (role == 1){
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