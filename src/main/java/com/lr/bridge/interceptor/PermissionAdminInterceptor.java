package com.lr.bridge.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员拦截器，页面只能普通用户访问
 * Created by ALTERUI on 2019/5/6 13:44
 */
public class PermissionAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if ((Integer) httpServletRequest.getSession().getAttribute("permission") == 1) {
            return true;
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/notFound");
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
