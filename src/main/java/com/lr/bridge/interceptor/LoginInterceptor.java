package com.lr.bridge.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器，防止越界访问
 * Created by ALTERUI on 2019/4/10 15:01
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("用户名为：" + httpServletRequest.getSession().getAttribute("userName"));
        if (httpServletRequest.getSession().getAttribute("userName") != null) {
            return true;
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/page/loginAndReg/login.jsp");
            return false;
        }



    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }
}
