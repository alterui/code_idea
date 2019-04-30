package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.service.BeamQualityService;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;
import com.lr.bridge.vo.EntityPassRateDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/page/beam")
public class BeamQualityController {
	
	@Resource
	private BeamQualityService beamQualityService;
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
                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize){

        model.addAttribute("pageUrlPrefix", "/page/beam?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/beamQuality";

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
                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        model.addAttribute("pageUrlPrefix", "/page/beam/hasQuality?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/hasBeamQuality";

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
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            @PathVariable("id") Integer id){

       //0代表不合格，1代表合格
        beamQualityService.updateByIsQualify(1, id);

        model.addAttribute("pageUrlPrefix", "/page/beam?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/beamQuality";

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
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        beamQualityService.updateByIsQualify(0, id);

        model.addAttribute("pageUrlPrefix", "/page/beam?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/beamQuality";

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
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        beamQualityService.updateByIsQualify(1, id);

        model.addAttribute("pageUrlPrefix", "/page/beam/hasQuality?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/hasBeamQuality";

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
                                @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                @PathVariable("id") Integer id){

        //0代表不合格，1代表合格
        beamQualityService.updateByIsQualify(0, id);

        model.addAttribute("pageUrlPrefix", "/page/beam/hasQuality?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/hasBeamQuality";

    }


    /**
     * 墩显示数据
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/show")
    public String show(HttpServletRequest request,
                        Model model,
                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/beamCrudPage/beamCrudPage";

    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteBeam(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        beamQualityService.deleteById(id);

        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/beamCrudPage/beamCrudPage";
    }


    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
    @ResponseBody
    public List<String> deleteBeamMore(HttpServletRequest request,
                                       Model model,
                                       @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                beamQualityService.deleteById(Integer.parseInt(id));

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
    @RequestMapping(value = "/edit/{id}")
    public String editBeam(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        BeamQuality beam = beamQualityService.selectByPrimaryKey(id);
        model.addAttribute("beam", beam);
        return "page/beamCrudPage/beamEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updateBeam(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        BeamQuality beamQuality = new BeamQuality();



        //保存
        beamQuality.setId(Integer.parseInt(request.getParameter("id")));

        beamQuality.setStruId(request.getParameter("struId"));
        beamQuality.setAxialDevi(request.getParameter("axialDevi"));
        beamQuality.setSectionDevi(request.getParameter("sectionDevi"));
        beamQuality.setTopElevDevi(request.getParameter("topElevDevi"));
        beamQuality.setSegmHeightDevi(request.getParameter("segmHeightDevi"));
        beamQuality.setHeightDevi(request.getParameter("heightDevi"));
        beamQuality.setCrossSlopeDevi(request.getParameter("crossSlopeDevi"));
        beamQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        beamQuality.setSmooDevi(request.getParameter("smooDevi"));
        beamQuality.setCableTubeAxisDevi(request.getParameter("cableTubeAxisDevi"));
        beamQuality.setPrestTendDevi(request.getParameter("prestTendDevi"));
        beamQuality.setCableTensi(request.getParameter("cableTensi"));
        beamQuality.setBridgeSite(request.getParameter("bridgeSite"));
        //修改表明重新测量，时间更新
        beamQuality.setBeamqualityCheckTime(new Date());

        //修改数据后要重新质量验收
        beamQuality.setIsQualify(-1);

        beamQualityService.updateByPrimaryKey(beamQuality);

        //show
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/beamCrudPage/beamCrudPage";
    }

    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addBeam(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        BeamQuality beamQuality = new BeamQuality();

        //保存
        beamQuality.setStruId(request.getParameter("struId"));
        beamQuality.setAxialDevi(request.getParameter("axialDevi"));
        beamQuality.setSectionDevi(request.getParameter("sectionDevi"));
        beamQuality.setTopElevDevi(request.getParameter("topElevDevi"));
        beamQuality.setSegmHeightDevi(request.getParameter("segmHeightDevi"));
        beamQuality.setHeightDevi(request.getParameter("heightDevi"));
        beamQuality.setCrossSlopeDevi(request.getParameter("crossSlopeDevi"));
        beamQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        beamQuality.setSmooDevi(request.getParameter("smooDevi"));
        beamQuality.setCableTubeAxisDevi(request.getParameter("cableTubeAxisDevi"));
        beamQuality.setPrestTendDevi(request.getParameter("prestTendDevi"));
        beamQuality.setCableTensi(request.getParameter("cableTensi"));
        beamQuality.setBridgeSite(request.getParameter("bridgeSite"));

        beamQuality.setBeamqualityCheckTime(new Date());
        beamQuality.setIsQualify(-1);
        beamQualityService.insert(beamQuality);
        //show
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/beamCrudPage/beamCrudPage";
    }

    /**
     * 搜索
     */
    @RequestMapping(value = "/search")
    public String searchName(HttpServletRequest request,
                          Model model,
                          @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                          @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        PageInfo<BeamQuality> beamQualityList = beamQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        //PageInfo<beamQuality> beamQualityInfo = beamQualityService.showBeam(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityList);
        return "page/beamCrudPage/beamCrudPage";
    }



    /**
     * 已经验收页面搜索
     */
    @RequestMapping(value = "/qualitySearch")
    public String qualitySearchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        //取值
        String name = request.getParameter("qualitySearch");
        PageInfo<BeamQuality> beamQualityList = beamQualityService.selectByLikeNameAndQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        model.addAttribute("pageInfo", beamQualityList);
        return "page/qualityPage/hasBeamQuality";
    }


    /**
     * 未验收页面搜索
     */
    @RequestMapping(value = "/notQualitySearch")
    public String notQualitySearchName(HttpServletRequest request,
                                    Model model,
                                    @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                    @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        //取值
        String name = request.getParameter("notQualitySearch");
        PageInfo<BeamQuality> beamQualityList = beamQualityService.selectByLikeNameAndNotQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");
        model.addAttribute("pageInfo", beamQualityList);
        return "page/qualityPage/beamQuality";
    }




    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/beamStandard")
    public String beamStandard(HttpServletRequest request,
                           Model model) {

        //标准值Id默认为1
        BeamQuality beam = beamQualityService.selectByPrimaryKey(1);
        model.addAttribute("beam", beam);
        return "page/standardPage/beamStandard";
    }



    /**
     * 修改标准值
     */
    @RequestMapping(value = "/updateStandard")
    public String updateBeamStandard(HttpServletRequest request,
                             Model model) {




        BeamQuality beamQuality = new BeamQuality();
        BeamQuality beam = beamQualityService.selectByPrimaryKey(1);
        //保存
        beamQuality.setId(1);
        beamQuality.setStruId("标准值");


        beamQuality.setAxialDevi(request.getParameter("axialDevi"));
        beamQuality.setSectionDevi(request.getParameter("sectionDevi"));
        beamQuality.setTopElevDevi(request.getParameter("topElevDevi"));
        beamQuality.setSegmHeightDevi(request.getParameter("segmHeightDevi"));
        beamQuality.setHeightDevi(request.getParameter("heightDevi"));
        beamQuality.setCrossSlopeDevi(request.getParameter("crossSlopeDevi"));
        beamQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        beamQuality.setSmooDevi(request.getParameter("smooDevi"));
        beamQuality.setCableTubeAxisDevi(request.getParameter("cableTubeAxisDevi"));
        beamQuality.setPrestTendDevi(request.getParameter("prestTendDevi"));
        beamQuality.setCableTensi(request.getParameter("cableTensi"));
        beamQuality.setBridgeSite(request.getParameter("bridgeSite"));


        //标准值特有为2
        beamQuality.setIsQualify(2);

        beamQuality.setBeamqualityCheckTime(new Date());

        beamQualityService.updateByPrimaryKey(beamQuality);

        //回显
        //标准值Id默认为1
        BeamQuality beamStandard = beamQualityService.selectByPrimaryKey(1);
        model.addAttribute("beam", beamStandard);
        return "page/standardPage/beamStandard";

    }

    /**
     * json格式返回到ajax
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(value = "/getChart")
    @ResponseBody
    public List<EntityPassRateDate> getChart(HttpServletRequest request,
                                             Model model) {



        List<EntityPassRateDate> results = new ArrayList<EntityPassRateDate>();
        String start = request.getParameter("start");
        start = start + "  00:00:00";
        String end = request.getParameter("end");
        end = end + "  23:59:59";
        try {
            List<EntityCountDateList> lists = beamQualityService.getIsQualityCountByDate(start,end);
            //用于存放返回到ajax的值

            for (EntityCountDateList list : lists) {

                List temp = new ArrayList();
               /* System.out.println(list.getCheckTime());*/

                for (EntityCountDate date : list.getEntityCounts()) {
                    //0代表不合格，1代表合格
                    /**
                     * 1.先算出合格率
                     * 2.构造一个List对象集合，对象为折线图的x，y轴
                     */
                    //02(不合格，有两个)  11(合格，1个)
                    temp.add(date.getIsQuality());
                    temp.add(date.getCount());
                    /*System.out.println(date.getIsQuality());
                    System.out.println(date.getCount());*/
                }
                //存放对象的值
                EntityPassRateDate passRateDate = new EntityPassRateDate();

                //开始算合格率
                /**
                 * 可能有2，或者4个
                 */
                if (temp.size() == 2) {
                    //02，不合格，即合格率为0
                    if (Integer.parseInt(temp.get(0).toString()) == 0) {
                        passRateDate.setPassRate("0");
                    }
                    if (Integer.parseInt(temp.get(0).toString()) == 1) {
                        passRateDate.setPassRate("1");
                    }
                } else if (temp.size() == 4) {
                    //02(不合格，有两个)  11(合格，1个)
                    DecimalFormat df   = new DecimalFormat("######0.00");
                    double tempDouble = Double.parseDouble(temp.get(3).toString()) / (Double.parseDouble(temp.get(3).toString()) + Double.parseDouble(temp.get(1).toString()));
                    passRateDate.setPassRate(String.valueOf(df.format(tempDouble)));
                }

                passRateDate.setCheckTime(list.getCheckTime());

                results.add(passRateDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }



    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/showChart")
    public String showCharts(HttpServletRequest request,
                               Model model) {

        return "page/chartsPage/beamPassRate";
    }


    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/addData")
    public String addData(HttpServletRequest request,
                             Model model) {

        return "page/beamCrudPage/beamAddPage";
    }


    /**
     * 根据日期查找
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getSearch")
    public String getSearch(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        PageInfo<BeamQuality> beamQualityPageInfo = beamQualityService.selectByDate(startTime, endTime, pageIndex, pageSize);


        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/beam/show?pageIndex");


        model.addAttribute("pageInfo", beamQualityPageInfo);
        return "page/beamCrudPage/beamCrudPage";

    }


    /**
     * 待验收页面的按日期搜索
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getQualitySearch")
    public String getQualitySearch(HttpServletRequest request,
                        Model model,
                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize){

        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/beam?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectQualityByDate(-1,startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/beamQuality";

    }



    /**
     * 已经验收页面的按日期搜索
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getHasQualitySearch")
    public String getHasQualitySearch(HttpServletRequest request,
                                   Model model,
                                   @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize){

        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/beam/hasQuality?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectHasQualityByDate(startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/hasBeamQuality";

    }




    /**
     * 批量不合格
     *
     */
    @RequestMapping(value = "/notQualityMore")
    @ResponseBody
    public List<String> notQualityBeamMore(HttpServletRequest request,
                                       Model model,
                                       @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                beamQualityService.updateByIsQualify(0, Integer.parseInt(id));
            }
        } catch (NumberFormatException e) {
            result.add("批量操作失败");
            e.printStackTrace();
        }

        return result;
    }




    /**
     * 批量合格
     *
     */
    @RequestMapping(value = "/qualityMore")
    @ResponseBody
    public List<String> qualityBeamMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                beamQualityService.updateByIsQualify(1, Integer.parseInt(id));
            }
        } catch (NumberFormatException e) {
            result.add("批量操作失败");
            e.printStackTrace();
        }

        return result;
    }



    /**
     * 更改
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @param id
     * @return
     */
    @RequestMapping("/updateQualified/{id}")
    public String updateQualified(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            @PathVariable("id") Integer id){

        //查数据库isQualify的值

        BeamQuality beamQuality = beamQualityService.selectByPrimaryKey(id);

        if (beamQuality.getIsQualify() == 1) {
            //1代表合格，更改为不合格
            beamQualityService.updateByIsQualify(0, id);

        } else if (beamQuality.getIsQualify() == 0){
            // //0代表不合格，1代表合格
            beamQualityService.updateByIsQualify(1, id);

        }

        model.addAttribute("pageUrlPrefix", "/page/beam/hasQuality?pageIndex");
        PageInfo<BeamQuality> beamQualityInfo = beamQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", beamQualityInfo);
        return "page/qualityPage/hasBeamQuality";

    }




}