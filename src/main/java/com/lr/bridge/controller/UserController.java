package com.lr.bridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.pojo.User;
import com.lr.bridge.service.BeamQualityService;
import com.lr.bridge.service.BearingQualityService;
import com.lr.bridge.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userService;
    @Resource
    private BeamQualityService beamQualityService;

    @RequestMapping("/reg")
    public String register(HttpServletRequest request,
                          Model model) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String fullName = request.getParameter("fullName");
        Map<String, String> map = userService.register(userName, fullName,password,repassword);
        if (map.get("msg") == null) {
            return "page/loginAndRegPage/login";
        } else {
            model.addAttribute("msg", map.get("msg"));
            return "page/loginAndRegPage/register";
        }

    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Map<String, String> map = userService.login(userName,password);
        if (map.get("msg") == null) {
            User user = userService.getUser(userName);
            session.setAttribute("userName", user.getFullName());
            session.setAttribute("permission", user.getPermission());

            //普通用户
            if (user.getPermission() == 0) {

                model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
                PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
                model.addAttribute("pageInfo", beamQualityInfo);
                return "page/beamCrudPage/beamCrudPage";

            }
            //管理员用户
            if (user.getPermission() == 1) {
                model.addAttribute("pageUrlPrefix", "/page/beam?pageIndex");
                PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showQuality(pageIndex, pageSize);
                model.addAttribute("pageInfo", beamQualityInfo);
                return "page/qualityPage/beamQuality";
            }

            return "/";





        } else {
            model.addAttribute("msg", map.get("msg"));
            return "page/loginAndRegPage/login";
        }

    }



    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model, HttpSession session) {


        session.removeAttribute("userName");
        return "page/loginAndRegPage/login";
    }

    @RequestMapping("/register")
    public String registerPage(HttpServletRequest request, Model model) {

        return "page/loginAndRegPage/register";
    }



}
