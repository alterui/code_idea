package com.lr.bridge.controller;

import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/27 11:05
 */
@Controller
public class IndexController {

    @Resource
    private BearingQualityService bearingQualityService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        List<BearingQuality> bearingStruId = bearingQualityService.getBearingStruId();

        model.addAttribute("bearName", bearingStruId);
        return "page/index";
    }
}
