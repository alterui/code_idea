package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/page/bear")
public class BearingQualityController {
	
	@Resource
	private BearingQualityService bearingQualityService;

    @RequestMapping("")
    public String register(HttpServletRequest request,
                          Model model,
                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "4") Integer pageSize){



        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");

        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.pageArticle(pageIndex, pageSize);


        model.addAttribute("pageInfo", bearingQualityInfo);


        return "page/qualityPage/bearQuality";

    }









}
