package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page/bear")
public class BearingQualityController {
	
	@Resource
	private BearingQualityService bearingQualityService;
    /**
     * 显示验证合格与不合格的页面
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("")
    public String index(HttpServletRequest request,
                          Model model,
                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "6") Integer pageSize){

        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }

    /**
     * 已经质量验收的页面显示
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/hasQuality")
    public String hasQuality(HttpServletRequest request,
                        Model model,
                        @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "6") Integer pageSize){
        model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";

    }

    /**
     * 判定合格
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/qualified/{id}")
    public String qualified(HttpServletRequest request,
                           Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                            @PathVariable("id") Integer id){

       //0代表不合格，1代表合格
        bearingQualityService.updateByIsQualify(1, id);

        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }

    /**
     * 判定不合格
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/notQualified/{id}")
    public String notQualified(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                            @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        bearingQualityService.updateByIsQualify(0, id);

        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }


    /**
     * 更改为合格
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/editQualified/{id}")
    public String exitQualified(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                            @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        bearingQualityService.updateByIsQualify(1, id);

        model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";

    }


    /**
     * 更改为不合格
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/editNotQualified/{id}")
    public String notExitQualified(HttpServletRequest request,
                                Model model,
                                @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                                @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        bearingQualityService.updateByIsQualify(0, id);

        model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";

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
        //String isQualify = request.getParameter("isQualify");
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

        //修改数据后要重新质量验收
        bearingQuality.setIsQualify(-1);

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
                          @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        PageInfo<BearingQuality> bearingQualityList = bearingQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/crudPage/bearCrudPage";
    }



    /**
     * 已经验收页面搜索
     */
    @RequestMapping(value = "/qualitySearch")
    public String qualitySearchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        //取值
        String name = request.getParameter("qualitySearch");
        PageInfo<BearingQuality> bearingQualityList = bearingQualityService.selectByLikeNameAndQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/qualityPage/hasBearQuality";
    }


    /**
     * 未验收页面搜索
     */
    @RequestMapping(value = "/notQualitySearch")
    public String notQualitySearchName(HttpServletRequest request,
                                    Model model,
                                    @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                    @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        //取值
        String name = request.getParameter("notQualitySearch");
        PageInfo<BearingQuality> bearingQualityList = bearingQualityService.selectByLikeNameAndNotQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/qualityPage/bearQuality";
    }




    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/bearStandard")
    public String bearStandard(HttpServletRequest request,
                           Model model) {

        //标准值Id默认为1
        BearingQuality bear = bearingQualityService.selectByPrimaryKey(1);
        model.addAttribute("bear", bear);
        return "page/standardPage/bearStandard";
    }



    /**
     * 修改标准值
     */
    @RequestMapping(value = "/updateStandard")
    public String updateBearStandard(HttpServletRequest request,
                             Model model) {



        String upCentVert = request.getParameter("upCentVert");
        String downCentTran = request.getParameter("downCentTran");
        String sameCentVert = request.getParameter("sameCentVert");
        String sameRela = request.getParameter("sameRela");
        String edgeHeig = request.getParameter("edgeHeig");
        String crossLineTors = request.getParameter("crossLineTors");
        String actiVert = request.getParameter("actiVert");
        //String bearingqualityCheckTime = request.getParameter("bearingqualityCheckTime");
        //String isQualify = request.getParameter("isQualify");
        BearingQuality bearingQuality = new BearingQuality();
        BearingQuality bear = bearingQualityService.selectByPrimaryKey(1);
        //保存
        bearingQuality.setId(1);
        bearingQuality.setStruId("标准值");
        bearingQuality.setUpCentVert(upCentVert);
        bearingQuality.setDownCentTran(downCentTran);
        bearingQuality.setSameCentVert(sameCentVert);
        bearingQuality.setSameRela(sameRela);
        bearingQuality.setEdgeHeig(edgeHeig);
        bearingQuality.setCrossLineTors(crossLineTors);
        bearingQuality.setActiVert(actiVert);
        bearingQuality.setIsQualify(2);

        bearingQuality.setBearingqualityCheckTime(new Date());

        bearingQualityService.updateByPrimaryKey(bearingQuality);

        //回显
        //标准值Id默认为1
        BearingQuality bearStandard = bearingQualityService.selectByPrimaryKey(1);
        model.addAttribute("bear", bearStandard);
        return "page/standardPage/bearStandard";

    }

    /**
     * json格式返回到ajax
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(value = "/getChart")
    @ResponseBody
    public String getChart(HttpServletRequest request,
                               Model model) {




        try {
            List<EntityCountDateList> lists = bearingQualityService.getIsQualityCountByDate();
            for (EntityCountDateList list : lists) {
                System.out.println(list.getCheckTime());
                List b = new ArrayList();

                for (EntityCountDate date : list.getEntityCounts()) {
                    //0代表不合格，1代表合格
                    /**
                     * 1.先算出合格率
                     * 2.构造一个List对象集合，对象为折线图的x，y轴
                     */

                    System.out.println(date.getIsQuality());

                    System.out.println(date.getCount());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




        //标准值Id默认为1
        String start = request.getParameter("start");




        return "page/standardPage/bearStandard";
    }

}