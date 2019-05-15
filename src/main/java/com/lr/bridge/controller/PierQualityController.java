package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.PierQuality;
import com.lr.bridge.service.PierQualityService;
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
@RequestMapping("/page/pier")
public class PierQualityController {
	
	@Resource
	private PierQualityService pierQualityService;
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
        model.addAttribute("pageUrlPrefix", "/page/pier?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/pierQuality";

    }

    /**
     * 已经质量验收的页面[显示]
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
        model.addAttribute("pageUrlPrefix", "/page/pier/hasQuality?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/hasPierQuality";

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
        pierQualityService.updateByIsQualify(1, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/pier?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/pierQuality";*/
        return "redirect:/page/pier/";

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
        pierQualityService.updateByIsQualify(0, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/pier?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/pierQuality";*/

        return "redirect:/page/pier/";
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
        pierQualityService.updateByIsQualify(1, id);

       /* model.addAttribute("pageUrlPrefix", "/page/Pier/hasQuality?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/hasPierQuality";*/

        return "redirect:/page/pier/hasQuality";
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
        pierQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/pier/hasQuality?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/hasPierQuality";*/
        return "redirect:/page/pier/hasQuality";

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

        model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showPier(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/pierCrudPage/pierCrudPage";

    }


    private void getRedShow(Model model) {
        PierQuality pierQuality = pierQualityService.selectByPrimaryKey(1);

        String length = pierQuality.getLength();
        String lengthSubstring = length.substring(1);
        double lengthStandardRight = Double.parseDouble(lengthSubstring);
        double lengthStandardLeft = Math.negateExact(Integer.parseInt(lengthSubstring));
        model.addAttribute("lengthStandardLeft", lengthStandardLeft);
        model.addAttribute("lengthStandardRight", lengthStandardRight);



        String width = pierQuality.getWidth();
        String widthSubstring = width.substring(1);
        double widthStandardRight = Double.parseDouble(widthSubstring);
        double widthStandardLeft = Math.negateExact(Integer.parseInt(widthSubstring));
        model.addAttribute("widthStandardLeft", widthStandardLeft);
        model.addAttribute("widthStandardRight", widthStandardRight);


        String topElev = pierQuality.getTopElev();
        String topElevSubstring = topElev.substring(1);
        double topElevStandardRight = Double.parseDouble(topElevSubstring);
        double topElevStandardLeft = Math.negateExact(Integer.parseInt(topElevSubstring));
        model.addAttribute("topElevStandardLeft", topElevStandardLeft);
        model.addAttribute("topElevStandardRight", topElevStandardRight);


        String axisOffs = pierQuality.getAxisOffs();
        String axisOffsSubstring = axisOffs.substring(1);
        double axisOffsStandardRight = Double.parseDouble(axisOffsSubstring);
        double axisOffsStandardLeft = Math.negateExact(Integer.parseInt(axisOffsSubstring));
        model.addAttribute("axisOffsStandardLeft", axisOffsStandardLeft);
        model.addAttribute("axisOffsStandardRight", axisOffsStandardRight);


        String vert = pierQuality.getVert();
        String vertSubstring = vert.substring(1);
        double vertStandardRight = Double.parseDouble(vertSubstring);
        double vertStandardLeft = Math.negateExact(Integer.parseInt(vertSubstring));
        model.addAttribute("vertStandardLeft", vertStandardLeft);
        model.addAttribute("vertStandardRight", vertStandardRight);



        model.addAttribute("surfVertStandard", Double.parseDouble(pierQuality.getSurfVert()));
        model.addAttribute("planenessStandard", Double.parseDouble(pierQuality.getPlaneness()));
        model.addAttribute("inteFaultTableStandard", Double.parseDouble(pierQuality.getInteFaultTable()));

    }



    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deletePier(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        pierQualityService.deleteById(id);

       /* model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showPier(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/pierCrudPage/pierCrudPage";*/
        return "redirect:/page/pier/show";
    }


    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/edit/{id}")
    public String editPier(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        PierQuality pier = pierQualityService.selectByPrimaryKey(id);
        model.addAttribute("pier", pier);
        return "page/pierCrudPage/pierEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updatePier(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PierQuality pierQuality = new PierQuality();



        //保存
        pierQuality.setId(Integer.parseInt(request.getParameter("id")));

        pierQuality.setStruId(request.getParameter("struId"));
        pierQuality.setLength(request.getParameter("length"));
        pierQuality.setWidth(request.getParameter("width"));
        pierQuality.setTopElev(request.getParameter("topElev"));
        pierQuality.setAxisOffs(request.getParameter("axisOffs"));
        pierQuality.setVert(request.getParameter("vert"));
        pierQuality.setSurfVert(request.getParameter("surfVert"));
        pierQuality.setPlaneness(request.getParameter("planeness"));
        pierQuality.setInteFaultTable(request.getParameter("inteFaultTable"));

        //修改表明重新测量，时间更新
        pierQuality.setPierqualityCheckTime(new Date());

        //修改数据后要重新质量验收
        pierQuality.setIsQualify(-1);

        pierQualityService.updateByPrimaryKey(pierQuality);

        //show
        /*model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showPier(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/pierCrudPage/pierCrudPage";*/
        return "redirect:/page/pier/show";
    }

    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addPier(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        PierQuality pierQuality = new PierQuality();

        //保存
        pierQuality.setStruId(request.getParameter("struId"));
        pierQuality.setLength(request.getParameter("length"));
        pierQuality.setWidth(request.getParameter("width"));
        pierQuality.setTopElev(request.getParameter("topElev"));
        pierQuality.setAxisOffs(request.getParameter("axisOffs"));
        pierQuality.setVert(request.getParameter("vert"));
        pierQuality.setSurfVert(request.getParameter("surfVert"));
        pierQuality.setPlaneness(request.getParameter("planeness"));
        pierQuality.setInteFaultTable(request.getParameter("inteFaultTable"));




        pierQuality.setPierqualityCheckTime(new Date());
        pierQuality.setIsQualify(-1);
        pierQualityService.insert(pierQuality);
        //show
      /*  model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.showPier(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/pierCrudPage/pierCrudPage";*/
        return "redirect:/page/pier/show";
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
        PageInfo<PierQuality> pierQualityList = pierQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        //PageInfo<pierQuality> pierQualityInfo = pierQualityService.showPier(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityList);
        return "page/pierCrudPage/pierCrudPage";
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
        PageInfo<PierQuality> pierQualityList = pierQualityService.selectByLikeNameAndQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        model.addAttribute("pageInfo", pierQualityList);
        return "page/qualityPage/hasPierQuality";
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
        PageInfo<PierQuality> pierQualityList = pierQualityService.selectByLikeNameAndNotQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");
        model.addAttribute("pageInfo", pierQualityList);
        return "page/qualityPage/pierQuality";
    }




    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/pierStandard")
    public String pierStandard(HttpServletRequest request,
                           Model model) {

        //标准值Id默认为1
        PierQuality pier = pierQualityService.selectByPrimaryKey(1);
        model.addAttribute("pier", pier);
        return "page/standardPage/pierStandard";
    }



    /**
     * 修改标准值
     */
    @RequestMapping(value = "/updateStandard")
    public String updatePierStandard(HttpServletRequest request,
                             Model model) {




        PierQuality pierQuality = new PierQuality();
        PierQuality pier = pierQualityService.selectByPrimaryKey(1);
        //保存
        pierQuality.setId(1);
        pierQuality.setStruId("标准值");


        pierQuality.setLength(request.getParameter("length"));
        pierQuality.setWidth(request.getParameter("width"));
        pierQuality.setTopElev(request.getParameter("topElev"));
        pierQuality.setAxisOffs(request.getParameter("axisOffs"));
        pierQuality.setVert(request.getParameter("vert"));
        pierQuality.setSurfVert(request.getParameter("surfVert"));
        pierQuality.setPlaneness(request.getParameter("planeness"));
        pierQuality.setInteFaultTable(request.getParameter("inteFaultTable"));



        //标准值特有为2
        pierQuality.setIsQualify(2);

        pierQuality.setPierqualityCheckTime(new Date());

        pierQualityService.updateByPrimaryKey(pierQuality);

        //回显
        //标准值Id默认为1
        PierQuality pierStandard = pierQualityService.selectByPrimaryKey(1);
        model.addAttribute("pier", pierStandard);
        return "page/standardPage/pierStandard";

    }

    /**
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
            List<EntityCountDateList> lists = pierQualityService.getIsQualityCountByDate(start, end);
            int notPassCount = pierQualityService.selectCountByDate(start, end, 0);
            int passCount = pierQualityService.selectCountByDate(start, end, 1);
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

        return "page/chartsPage/pierPassRate";
    }


    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/addData")
    public String addData(HttpServletRequest request,
                             Model model) {

        return "page/pierCrudPage/pierAddPage";
    }


    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
    @ResponseBody
    public List<String> deletePierMore(HttpServletRequest request,
                                       Model model,
                                       @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                pierQualityService.deleteById(Integer.parseInt(id));

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

        PageInfo<PierQuality> pierQualityPageInfo = pierQualityService.selectByDateAll(startTime, endTime, pageIndex, pageSize);


        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/pier/show?pageIndex");


        model.addAttribute("pageInfo", pierQualityPageInfo);
        return "page/pierCrudPage/pierCrudPage";

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



        PageInfo<PierQuality> pierQualityPageInfo = pierQualityService.selectByDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/page/pier/getSearch?pageIndex");
        model.addAttribute("pageInfo", pierQualityPageInfo);
        return "page/chartsPage/pierChartPage";

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

        model.addAttribute("pageUrlPrefix", "/page/pier?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectQualityByDate(-1,startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/pierQuality";

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

        model.addAttribute("pageUrlPrefix", "/page/pier/hasQuality?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectHasQualityByDate(startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/hasPierQuality";

    }




    /**
     * 批量不合格
     *
     */
    @RequestMapping(value = "/notQualityMore")
    @ResponseBody
    public List<String> notQualityPierMore(HttpServletRequest request,
                                           Model model,
                                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                pierQualityService.updateByIsQualify(0, Integer.parseInt(id));
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
    public List<String> qualityPierMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                pierQualityService.updateByIsQualify(1, Integer.parseInt(id));
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

        PierQuality pierQuality = pierQualityService.selectByPrimaryKey(id);

        if (pierQuality.getIsQualify() == 1) {
            //1代表合格，更改为不合格
            pierQualityService.updateByIsQualify(0, id);

        } else if (pierQuality.getIsQualify() == 0){
            // //0代表不合格，1代表合格
            pierQualityService.updateByIsQualify(1, id);

        }

      /*  model.addAttribute("pageUrlPrefix", "/page/pier/hasQuality?pageIndex");
        PageInfo<PierQuality> pierQualityInfo = pierQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pierQualityInfo);
        return "page/qualityPage/hasPierQuality";*/
        return "redirect:/page/pier/hasQuality";

    }






}