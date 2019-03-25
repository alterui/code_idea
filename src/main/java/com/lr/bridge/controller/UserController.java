package com.lr.bridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lr.bridge.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userService;

    @RequestMapping("/reg")
    public String register(HttpServletRequest request,
                          Model model) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        Map<String, String> map = userService.register(userName, password,repassword);
        if (map.get("msg") == null) {
            return "page/login";
        } else {
            model.addAttribute("msg", map.get("msg"));
            return "page/register";
        }

    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpSession session) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Map<String, String> map = userService.login(userName,password);
        if (map.get("msg") == null) {
            session.setAttribute("userName", userName);
            return "page/index";
        } else {
            model.addAttribute("msg", map.get("msg"));
            return "page/login";
        }

    }



    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model, HttpSession session) {


        session.removeAttribute("userName");
        return "page/login";
    }



}
