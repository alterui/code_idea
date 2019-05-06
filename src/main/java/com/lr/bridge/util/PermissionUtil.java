package com.lr.bridge.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 权限管理工具类
 * Created by ALTERUI on 2019/5/6 10:32
 */
public class PermissionUtil {

    /**
     * 只有管理员用户可以访问，其他用户访问跳转404页面
     * @param request
     * @return
     */
    public static boolean getAdminPermission(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int permission = (Integer) session.getAttribute("permission");

        if (permission == 0) {
            return true;
        }
        return false;
    }


    /**
     * 只有普通用户可以访问，其他用户访问跳转404页面
     * @param request
     * @return
     */
    public static boolean getUserPermission(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int permission = (Integer) session.getAttribute("permission");

        if (permission == 1) {
            return true;
        }
        return false;
    }
}
