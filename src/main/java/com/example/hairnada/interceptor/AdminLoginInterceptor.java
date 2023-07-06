package com.example.hairnada.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("******************* adminLoginInterceptor preHandle*******************");
        Object membershipNumber = request.getSession().getAttribute("membershipNumber");

        if(membershipNumber == null){
            response.sendRedirect("/admin/adminLogin");
            return false;
        }
        return true;
    }
}
