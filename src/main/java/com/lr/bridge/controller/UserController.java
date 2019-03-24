package com.lr.bridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lr.bridge.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lr.bridge.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/show")
	public String getUser(HttpServletRequest request,Model model) {
		User user;
		user = userService.getUser(1);
		model.addAttribute("user", user);
		return "show";
	}
	
	@RequestMapping("/index")
	public String getIndex(HttpServletRequest request,Model model) {
		User user;
		user = userService.getUser(1);
		model.addAttribute("user", user);
		return "index";
	}
}
