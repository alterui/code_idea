package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.TowerQuality;
import com.lr.bridge.service.TowerQualityService;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;
import com.lr.bridge.vo.EntityPassRateDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;


@Controller
@RequestMapping("/page/tower")
public class TowerQualityController {
	
	@Resource
	private TowerQualityService towerQualityService;
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


        getRedShow(model);
        model.addAttribute("pageUrlPrefix", "/page/tower?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/towerQuality";

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

        getRedShow(model);
        model.addAttribute("pageUrlPrefix", "/page/tower/hasQuality?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/hasTowerQuality";

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
        towerQualityService.updateByIsQualify(1, id);

        /*model.addAttribute("pageUrlPrefix", "/page/tower?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/towerQuality";*/
        return "redirect:/page/tower/";

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
        towerQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/tower?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/towerQuality";*/
        return "redirect:/page/tower/";

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
        towerQualityService.updateByIsQualify(1, id);

       /* model.addAttribute("pageUrlPrefix", "/page/tower/hasQuality?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/hasTowerQuality";*/
        return "redirect:/page/tower/hasQuality";

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
        towerQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/tower/hasQuality?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/hasTowerQuality";*/
        return "redirect:/page/tower/hasQuality";

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

        getRedShow(model);
        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showTower(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/towerCrudPage/towerCrudPage";

    }



    private void getRedShow(Model model) {
        TowerQuality towerQuality = towerQualityService.selectByPrimaryKey(1);



        model.addAttribute("axisDeviStandard", Double.parseDouble(towerQuality.getAxisDevi()));


        String crossDimeDevi = towerQuality.getCrossDimeDevi();
        String crossDimeDeviSubstring = crossDimeDevi.substring(1);
        double crossDimeDeviStandardRight = Double.parseDouble(crossDimeDeviSubstring);
        double crossDimeDeviStandardLeft = Math.negateExact(Integer.parseInt(crossDimeDeviSubstring));
        model.addAttribute("crossDimeDeviStandardLeft", crossDimeDeviStandardLeft);
        model.addAttribute("crossDimeDeviStandardRight", crossDimeDeviStandardRight);


        model.addAttribute("vertStandard", Double.parseDouble(towerQuality.getVert()));


        String coluWallThic = towerQuality.getColuWallThic();
        String coluWallThicSubstring = coluWallThic.substring(1);
        double coluWallThicStandardRight = Double.parseDouble(coluWallThicSubstring);
        double coluWallThicStandardLeft = Math.negateExact(Integer.parseInt(coluWallThicSubstring));
        model.addAttribute("coluWallThicStandardLeft", coluWallThicStandardLeft);
        model.addAttribute("coluWallThicStandardRight", coluWallThicStandardRight);


        String anchnDevi = towerQuality.getAnchnDevi();
        String anchnDeviSubstring = anchnDevi.substring(1);
        double anchnDeviStandardRight = Double.parseDouble(anchnDeviSubstring);
        double anchnDeviStandardLeft = Math.negateExact(Integer.parseInt(anchnDeviSubstring));
        model.addAttribute("anchnDeviStandardLeft", anchnDeviStandardLeft);
        model.addAttribute("anchnDeviStandardRight", anchnDeviStandardRight);


        model.addAttribute("cableAxisDeviStandard", Double.parseDouble(towerQuality.getCableAxisDevi()));

        String crossbeamDimeDevi = towerQuality.getCrossbeamDimeDevi();
        String crossbeamDimeDeviSubstring = crossbeamDimeDevi.substring(1);
        double crossbeamDimeDeviStandardRight = Double.parseDouble(crossbeamDimeDeviSubstring);
        double crossbeamDimeDeviStandardLeft = Math.negateExact(Integer.parseInt(crossbeamDimeDeviSubstring));
        model.addAttribute("crossbeamDimeDeviStandardLeft", crossbeamDimeDeviStandardLeft);
        model.addAttribute("crossbeamDimeDeviStandardRight", crossbeamDimeDeviStandardRight);


        String crossbeamTopDevi = towerQuality.getCrossbeamTopDevi();
        String crossbeamTopDeviSubstring = crossbeamTopDevi.substring(1);
        double crossbeamTopDeviStandardRight = Double.parseDouble(crossbeamTopDeviSubstring);
        double crossbeamTopDeviStandardLeft = Math.negateExact(Integer.parseInt(crossbeamTopDeviSubstring));
        model.addAttribute("crossbeamTopDeviStandardLeft", crossbeamTopDeviStandardLeft);
        model.addAttribute("crossbeamTopDeviStandardRight", crossbeamTopDeviStandardRight);

        model.addAttribute("crossbeamAxisDeviStandard", Double.parseDouble(towerQuality.getCrossbeamAxisDevi()));


        String crossbeamThicDevi = towerQuality.getCrossbeamThicDevi();
        String crossbeamThicDeviSubstring = crossbeamThicDevi.substring(1);
        double crossbeamThicDeviStandardRight = Double.parseDouble(crossbeamThicDeviSubstring);
        double crossbeamThicDeviStandardLeft = Math.negateExact(Integer.parseInt(crossbeamThicDeviSubstring));
        model.addAttribute("crossbeamThicDeviStandardLeft", crossbeamThicDeviStandardLeft);
        model.addAttribute("crossbeamThicDeviStandardRight", crossbeamThicDeviStandardRight);

        model.addAttribute("embePartsDeviStandard", Double.parseDouble(towerQuality.getEmbePartsDevi()));

        model.addAttribute("jointDislStandard", Double.parseDouble(towerQuality.getJointDisl()));

    }

    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteTower(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        towerQualityService.deleteById(id);
/*
        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showTower(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/towerCrudPage/towerCrudPage";*/

        return "redirect:/page/tower/show";

    }


    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/edit/{id}")
    public String editTower(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        TowerQuality tower = towerQualityService.selectByPrimaryKey(id);
        model.addAttribute("tower", tower);
        return "page/towerCrudPage/towerEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updateTower(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        TowerQuality towerQuality = new TowerQuality();



        //保存
        towerQuality.setId(Integer.parseInt(request.getParameter("id")));

        towerQuality.setStruId(request.getParameter("struId"));
        towerQuality.setAxisDevi(request.getParameter("axisDevi"));
        towerQuality.setCrossDimeDevi(request.getParameter("crossDimeDevi"));
        towerQuality.setVert(request.getParameter("vert"));
        towerQuality.setColuWallThic(request.getParameter("coluWallThic"));
        towerQuality.setAnchnDevi(request.getParameter("anchnDevi"));
        towerQuality.setCableAxisDevi(request.getParameter("cableAxisDevi"));
        towerQuality.setCrossbeamDimeDevi(request.getParameter("crossbeamDimeDevi"));
        towerQuality.setCrossbeamTopDevi(request.getParameter("crossbeamTopDevi"));
        towerQuality.setCrossbeamAxisDevi(request.getParameter("crossbeamAxisDevi"));
        towerQuality.setCrossbeamThicDevi(request.getParameter("crossbeamThicDevi"));
        towerQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        towerQuality.setJointDisl(request.getParameter("jointDisl"));
        //修改表明重新测量，时间更新
        towerQuality.setTowerqualityCheckTime(new Date());

        //修改数据后要重新质量验收
        towerQuality.setIsQualify(-1);

        towerQualityService.updateByPrimaryKey(towerQuality);

        //show
      /*  model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showTower(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/towerCrudPage/towerCrudPage";*/
        return "redirect:/page/tower/show";
    }

    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addTower(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        TowerQuality towerQuality = new TowerQuality();

        //保存

        towerQuality.setStruId(request.getParameter("struId"));
        towerQuality.setAxisDevi(request.getParameter("axisDevi"));
        towerQuality.setCrossDimeDevi(request.getParameter("crossDimeDevi"));
        towerQuality.setVert(request.getParameter("vert"));
        towerQuality.setColuWallThic(request.getParameter("coluWallThic"));
        towerQuality.setAnchnDevi(request.getParameter("anchnDevi"));
        towerQuality.setCableAxisDevi(request.getParameter("cableAxisDevi"));
        towerQuality.setCrossbeamDimeDevi(request.getParameter("crossbeamDimeDevi"));
        towerQuality.setCrossbeamTopDevi(request.getParameter("crossbeamTopDevi"));
        towerQuality.setCrossbeamAxisDevi(request.getParameter("crossbeamAxisDevi"));
        towerQuality.setCrossbeamThicDevi(request.getParameter("crossbeamThicDevi"));
        towerQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        towerQuality.setJointDisl(request.getParameter("jointDisl"));



        towerQuality.setTowerqualityCheckTime(new Date());
        towerQuality.setIsQualify(-1);
        towerQualityService.insert(towerQuality);
        //show
        /*model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.showTower(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/towerCrudPage/towerCrudPage";*/

        return "redirect:/page/tower/show";
    }

    /**
     * 搜索
     */
    @RequestMapping(value = "/search")
    public String searchName(HttpServletRequest request,
                          Model model,
                          @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "100") Integer pageSize) {
        getRedShow(model);
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<TowerQuality> towerQualityList = towerQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        //PageInfo<towerQuality> towerQualityInfo = towerQualityService.showTower(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityList);
        return "page/towerCrudPage/towerCrudPage";
    }



    /**
     * 折线统计图上面的查看所有值
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getSearchChart")
    public String getSearchChart(HttpServletRequest request,
                                 Model model,
                                 @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                 @RequestParam(required = false, defaultValue = "120") Integer pageSize) {
        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        getRedShow(model);

        String[] split = start.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];

        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);



        PageInfo<TowerQuality> towerQualityPageInfo = towerQualityService.selectByDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/page/tower/getSearch?pageIndex");
        model.addAttribute("pageInfo", towerQualityPageInfo);
        return "page/chartsPage/towerChartPage";

    }



    /**
     * 已经验收页面搜索
     */
    @RequestMapping(value = "/qualitySearch")
    public String qualitySearchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "100") Integer pageSize) {

        getRedShow(model);
        //取值
        String name = request.getParameter("qualitySearch");
        model.addAttribute("search", name);
        PageInfo<TowerQuality> towerQualityList = towerQualityService.selectByLikeNameAndQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        model.addAttribute("pageInfo", towerQualityList);
        return "page/qualityPage/hasTowerQuality";
    }


    /**
     * 未验收页面搜索
     */
    @RequestMapping(value = "/notQualitySearch")
    public String notQualitySearchName(HttpServletRequest request,
                                    Model model,
                                    @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                    @RequestParam(required = false, defaultValue = "100") Integer pageSize) {

        getRedShow(model);
        //取值
        String name = request.getParameter("notQualitySearch");
        model.addAttribute("search", name);
        PageInfo<TowerQuality> towerQualityList = towerQualityService.selectByLikeNameAndNotQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");
        model.addAttribute("pageInfo", towerQualityList);
        return "page/qualityPage/towerQuality";
    }




    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/towerStandard")
    public String towerStandard(HttpServletRequest request,
                           Model model) {

        //标准值Id默认为1
        TowerQuality tower = towerQualityService.selectByPrimaryKey(1);
        model.addAttribute("tower", tower);
        return "page/standardPage/towerStandard";
    }



    /**
     * 修改标准值
     */
    @RequestMapping(value = "/updateStandard")
    public String updateTowerStandard(HttpServletRequest request,
                             Model model) {




        TowerQuality towerQuality = new TowerQuality();
        TowerQuality tower = towerQualityService.selectByPrimaryKey(1);
        //保存
        towerQuality.setId(1);
        towerQuality.setStruId("标准值");


        towerQuality.setAxisDevi(request.getParameter("axisDevi"));
        towerQuality.setCrossDimeDevi(request.getParameter("crossDimeDevi"));
        towerQuality.setVert(request.getParameter("vert"));
        towerQuality.setColuWallThic(request.getParameter("coluWallThic"));
        towerQuality.setAnchnDevi(request.getParameter("anchnDevi"));
        towerQuality.setCableAxisDevi(request.getParameter("cableAxisDevi"));
        towerQuality.setCrossbeamDimeDevi(request.getParameter("crossbeamDimeDevi"));
        towerQuality.setCrossbeamTopDevi(request.getParameter("crossbeamTopDevi"));
        towerQuality.setCrossbeamAxisDevi(request.getParameter("crossbeamAxisDevi"));
        towerQuality.setCrossbeamThicDevi(request.getParameter("crossbeamThicDevi"));
        towerQuality.setEmbePartsDevi(request.getParameter("embePartsDevi"));
        towerQuality.setJointDisl(request.getParameter("jointDisl"));


        //标准值特有为2
        towerQuality.setIsQualify(2);

        towerQuality.setTowerqualityCheckTime(new Date());

        towerQualityService.updateByPrimaryKey(towerQuality);

        //回显
        //标准值Id默认为1
        TowerQuality towerStandard = towerQualityService.selectByPrimaryKey(1);
        model.addAttribute("tower", towerStandard);
        return "page/standardPage/towerStandard";

    }

    /**
     * 折线统计图生成
     * json格式返回到ajax
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(value = "/getChart")
    @ResponseBody
    public Map getChart(HttpServletRequest request,
                        Model model) {



        Map results = new HashMap();
        String start = request.getParameter("start");
        start = start + "  00:00:00";
        String end = request.getParameter("end");
        end = end + "  23:59:59";
        try {
            List<EntityCountDateList> lists = towerQualityService.getIsQualityCountByDate(start, end);
            int notPassCount = towerQualityService.selectCountByDate(start, end, 0);
            int passCount = towerQualityService.selectCountByDate(start, end, 1);
            List<EntityPassRateDate> listDate = new ArrayList<>();
            //用于存放返回到ajax的值

            /**
             *  list为分组查询后的数据，EntityCountDateList的成员是
             *   private String checkTime; //每日的时间
             *   private List<EntityCountDate> entityCounts;
             *
             *          EntityCountDate
             *                ↓
             *      private int isQualify; //是否合格
             *      private int count;   //合格或者不合格的数量
             */

            for (EntityCountDateList list : lists) {

                List temp = new ArrayList();//用于存放是否合格及是否合格的数量

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
                 *
                 *
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

                listDate.add(passRateDate);


            }

            if (listDate.size() != 0) {

                results.put("passRateDate", listDate);
                results.put("notPassCount", notPassCount);
                results.put("passCount", passCount);
                results.put("code", 1);
            } else {
                results.put("code", 0);
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

        return "page/chartsPage/towerPassRate";
    }


    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/addData")
    public String addData(HttpServletRequest request,
                             Model model) {

        return "page/towerCrudPage/towerAddPage";
    }


    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
    @ResponseBody
    public List<String> deleteTowerMore(HttpServletRequest request,
                                       Model model,
                                       @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                towerQualityService.deleteById(Integer.parseInt(id));

            }
        } catch (NumberFormatException e) {
            result.add("删除失败");
            e.printStackTrace();
        }

        return result;
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
                            @RequestParam(required = false, defaultValue = "100") Integer pageSize) {
        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        PageInfo<TowerQuality> towerQualityPageInfo = towerQualityService.selectByDateAll(startTime, endTime, pageIndex, pageSize);


        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/tower/show?pageIndex");


        model.addAttribute("pageInfo", towerQualityPageInfo);
        return "page/towerCrudPage/towerCrudPage";

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
                                   @RequestParam(required = false, defaultValue = "100") Integer pageSize){

        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/tower?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectQualityByDate(-1,startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/towerQuality";

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
                                      @RequestParam(required = false, defaultValue = "100") Integer pageSize){

        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/tower/hasQuality?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectHasQualityByDate(startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/hasTowerQuality";

    }




    /**
     * 批量不合格
     *
     */
    @RequestMapping(value = "/notQualityMore")
    @ResponseBody
    public List<String> notQualityTowerMore(HttpServletRequest request,
                                           Model model,
                                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                towerQualityService.updateByIsQualify(0, Integer.parseInt(id));
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
    public List<String> qualityTowerMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                towerQualityService.updateByIsQualify(1, Integer.parseInt(id));
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

        TowerQuality towerQuality = towerQualityService.selectByPrimaryKey(id);

        if (towerQuality.getIsQualify() == 1) {
            //1代表合格，更改为不合格
            towerQualityService.updateByIsQualify(0, id);

        } else if (towerQuality.getIsQualify() == 0){
            // //0代表不合格，1代表合格
            towerQualityService.updateByIsQualify(1, id);

        }

       /* model.addAttribute("pageUrlPrefix", "/page/tower/hasQuality?pageIndex");
        PageInfo<TowerQuality> towerQualityInfo = towerQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", towerQualityInfo);
        return "page/qualityPage/hasTowerQuality";*/
        return "redirect:/page/tower/hasQuality";

    }





}