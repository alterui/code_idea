package com.lr.bridge.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.pojo.User;
import com.lr.bridge.service.BeamQualityService;
import com.lr.bridge.service.BearingQualityService;
import com.lr.bridge.service.impl.UserServiceImpl;
import com.lr.bridge.util.MD5Util;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl userService;
    @Resource
    private BeamQualityService beamQualityService;


    /**
     * 用户注册
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/reg")
    public String register(HttpServletRequest request,
                          Model model,
                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        //0为承包人，1为总监
        Integer permission = null;

        if ("总监".equals(request.getParameter("role"))) {

            permission = 1;
        } else if ("承包人".equals(request.getParameter("role"))) {
            permission = 0;

        }

        Map<String, String> map = userService.register(userName, fullName,password,permission);
        if (map.get("msg") == null) {
            PageInfo<User> userPageInfo = userService.showUser(pageIndex, pageSize);
            model.addAttribute("pageUrlPrefix", "/showUser?pageIndex");
            model.addAttribute("pageInfo", userPageInfo);
            return "page/userPage/showUser";

        } else {
            model.addAttribute("msg", map.get("msg"));
            return "page/userPage/addUser";
        }

    }

    /**
     * 登录
     * @param request
     * @param model
     * @param session
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

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


    /**
     * 登出
     * @param request
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model, HttpSession session) {


        session.removeAttribute("userName");
        return "page/loginAndRegPage/login";
    }

    /**
     * 添加用户页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String registerPage(HttpServletRequest request, Model model) {

        return "page/userPage/addUser";
    }


    /**
     * 用户列表显示
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model,
                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<User> userPageInfo = userService.showUser(pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/showUser?pageIndex");
        model.addAttribute("pageInfo", userPageInfo);
        return "page/userPage/showUser";


    }


    /**
     * 搜索
     */
    @RequestMapping(value = "/searchUser")
    public String searchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<User> userPageInfo = userService.selectByLikeName(name, pageIndex, pageSize);

        model.addAttribute("pageUrlPrefix", "/showUser?pageIndex");
        model.addAttribute("pageInfo", userPageInfo);
        return "page/userPage/showUser";

    }




    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteApply(HttpServletRequest request,
                              Model model,
                              @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                              @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                              @PathVariable("id") Integer id) {

        userService.deleteByPrimaryKey(id);
        PageInfo<User> userPageInfo = userService.showUser(pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/showUser?pageIndex");
        model.addAttribute("pageInfo", userPageInfo);
        return "page/userPage/showUser";


    }


    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteUserMore")
    @ResponseBody
    public List<String> deleteApplyMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                userService.deleteByPrimaryKey(Integer.parseInt(id));

            }
        } catch (NumberFormatException e) {
            result.add("删除失败");
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/editUser/{id}")
    public String editPile(HttpServletRequest request,
                           Model model,
                           @PathVariable("id") Integer id) {

        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "page/userPage/editUser";
    }



    /**
     * 用户修改
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public Map updateUser(HttpServletRequest request,
                           Model model,
                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String idString = request.getParameter("id");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
      /*  System.out.println(userName);
        System.out.println(1);*/

        //0为承包人，1为总监
        Integer permission = null;

        Map<String, Object> map = new HashMap<String, Object>();

        if ("总监".equals(request.getParameter("role"))) {

            permission = 1;
        } else if ("承包人".equals(request.getParameter("role"))) {
            permission = 0;

        }


        int id =  Integer.parseInt(idString);
        User oldUser = userService.selectByUserName(userName);
        //用户名已存在,但不是当前用户(编辑用户的时候，不提示)
        if (oldUser != null && oldUser.getId() != id) {
            map.put("code",1);
            map.put("msg", "用户名已存在！");

        } else {//

            User user = new User();

            user.setId(id);
            user.setUserName(userName);
            user.setPassword(MD5Util.getMD5(password));
            user.setFullName(fullName);
            user.setPermission(permission);

            userService.updateByPrimaryKey(user);
            map.put("code",0);
            map.put("msg","");


        }


        return map;
    }










}
