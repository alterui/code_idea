package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;




@Controller
@RequestMapping("/page/bear")
public class BearingQualityController {
	
	@Resource
	private BearingQualityService bearingQualityService;

    @RequestMapping("")
    public String index(HttpServletRequest request,
                          Model model,
                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "5") Integer pageSize){



        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.pageArticle(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }


    @RequestMapping("/qualified")
    public String qualified(HttpServletRequest request,
                           Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "5") Integer pageSize){


        String[] ids = request.getParameterValues("id");
        for (String id : ids) {
            String parameter = request.getParameter("bear_" + id + "");
            int isQualify = Integer.parseInt(parameter);
            //修改状态
            bearingQualityService.updateByIsQualify(isQualify, Integer.parseInt(id));

        }

        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.pageArticle(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }


    /**
     * 支座显示数据
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/show")
    public String show(HttpServletRequest request,
                        Model model,
                        @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "5") Integer pageSize){



        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/crudPage/bearCrudPage";

    }


    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                             @PathVariable("id") Integer id) {

        bearingQualityService.deleteById(id);

        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/crudPage/bearCrudPage";
    }



    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/edit/{id}")
    public String editBear(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        BearingQuality bear = bearingQualityService.selectByPrimaryKey(id);
        model.addAttribute("bear", bear);
        return "page/crudPage/bearEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updateBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        //取值
        String id = request.getParameter("id");
        String struId = request.getParameter("struId");
        String upCentVert = request.getParameter("upCentVert");
        String downCentTran = request.getParameter("downCentTran");
        String sameCentVert = request.getParameter("sameCentVert");
        String sameRela = request.getParameter("sameRela");
        String edgeHeig = request.getParameter("edgeHeig");
        String crossLineTors = request.getParameter("crossLineTors");
        String actiVert = request.getParameter("actiVert");
        //String bearingqualityCheckTime = request.getParameter("bearingqualityCheckTime");
        String isQualify = request.getParameter("isQualify");

        BearingQuality bearingQuality = new BearingQuality();


        BearingQuality bear = bearingQualityService.selectByPrimaryKey(Integer.parseInt(id));
        //保存
        bearingQuality.setId(Integer.parseInt(id));
        bearingQuality.setStruId(struId);
        bearingQuality.setUpCentVert(upCentVert);
        bearingQuality.setDownCentTran(downCentTran);
        bearingQuality.setSameCentVert(sameCentVert);
        bearingQuality.setSameRela(sameRela);
        bearingQuality.setEdgeHeig(edgeHeig);
        bearingQuality.setCrossLineTors(crossLineTors);
        bearingQuality.setActiVert(actiVert);
        bearingQuality.setBearingqualityCheckTime(bear.getBearingqualityCheckTime());

        bearingQuality.setIsQualify(bear.getIsQualify());

        bearingQualityService.updateByPrimaryKey(bearingQuality);

        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/crudPage/bearCrudPage";
    }



    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        //取值

        String struId = request.getParameter("struId");
        String upCentVert = request.getParameter("upCentVert");
        String downCentTran = request.getParameter("downCentTran");
        String sameCentVert = request.getParameter("sameCentVert");
        String sameRela = request.getParameter("sameRela");
        String edgeHeig = request.getParameter("edgeHeig");
        String crossLineTors = request.getParameter("crossLineTors");
        String actiVert = request.getParameter("actiVert");
        //String bearingqualityCheckTime = request.getParameter("bearingqualityCheckTime");
        String isQualify = request.getParameter("isQualify");



        BearingQuality bearingQuality = new BearingQuality();



        //保存

        bearingQuality.setStruId(struId);
        bearingQuality.setUpCentVert(upCentVert);
        bearingQuality.setDownCentTran(downCentTran);
        bearingQuality.setSameCentVert(sameCentVert);
        bearingQuality.setSameRela(sameRela);
        bearingQuality.setEdgeHeig(edgeHeig);
        bearingQuality.setCrossLineTors(crossLineTors);
        bearingQuality.setActiVert(actiVert);

        bearingQuality.setBearingqualityCheckTime(new Date());

        bearingQuality.setIsQualify(-1);

        bearingQualityService.insert(bearingQuality);

        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/crudPage/bearCrudPage";
    }



    /**
     * 搜索
     */
    @RequestMapping(value = "/search")
    public String searchName(HttpServletRequest request,
                          Model model,
                          @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                          @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        //取值
        String name = request.getParameter("search");


        PageInfo<BearingQuality> bearingQualityList = bearingQualityService.selectByLikeName(name, pageIndex, pageSize);
        System.out.println(bearingQualityList.getEndRow());
        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/crudPage/bearCrudPage";
    }









}
