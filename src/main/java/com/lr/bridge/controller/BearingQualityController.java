package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
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
@RequestMapping("/page/bear")
public class BearingQualityController {
	
	@Resource
	private BearingQualityService bearingQualityService;
    /**
     * 【显示】验证合格与不合格的页面
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
        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

    }

    /**
     *
     * 页面显示
     *
     *
     * 已经质量验收的页面【显示】
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
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                            @PathVariable("id") Integer id){

       //0代表不合格，1代表合格
        bearingQualityService.updateByIsQualify(1, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";*/
        return "redirect:/page/bear";

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
        bearingQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";*/
        return "redirect:/page/bear/";

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
        bearingQualityService.updateByIsQualify(1, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";*/
        return "redirect:/page/bear/hasQuality";

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
        bearingQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";*/

        return "redirect:/page/bear/hasQuality";


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
                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        getRedShow(model);
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);

        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/bearCrudPage/bearCrudPage";

    }



    private void getRedShow(Model model) {
        BearingQuality bearQuality = bearingQualityService.selectByPrimaryKey(1);

        String upCentVert = bearQuality.getUpCentVert();
        String upCentVertSubstring = upCentVert.substring(1);
        double upCentVertStandardRight = Double.parseDouble(upCentVertSubstring);
        double upCentVertStandardLeft = Math.negateExact(Integer.parseInt(upCentVertSubstring));
        model.addAttribute("upCentVertStandardLeft", upCentVertStandardLeft);
        model.addAttribute("upCentVertStandardRight", upCentVertStandardRight);

        String downCentTran = bearQuality.getDownCentTran();
        String downCentTranSubstring = downCentTran.substring(1);
        double downCentTranStandardRight = Double.parseDouble(downCentTranSubstring);
        double downCentTranStandardLeft = Math.negateExact(Integer.parseInt(downCentTranSubstring));
        model.addAttribute("downCentTranStandardLeft", downCentTranStandardLeft);
        model.addAttribute("downCentTranStandardRight", downCentTranStandardRight);


        String sameCentVert = bearQuality.getSameCentVert();
        String sameCentVertSubstring = sameCentVert.substring(1);
        double sameCentVertStandardRight = Double.parseDouble(sameCentVertSubstring);
        double sameCentVertStandardLeft = Math.negateExact(Integer.parseInt(sameCentVertSubstring));
        model.addAttribute("sameCentVertStandardLeft", sameCentVertStandardLeft);
        model.addAttribute("sameCentVertStandardRight", sameCentVertStandardRight);


        String sameRela = bearQuality.getSameRela();
        String sameRelaSubstring = sameRela.substring(1);
        double sameRelaStandardRight = Double.parseDouble(sameRelaSubstring);
        double sameRelaStandardLeft = Math.negateExact(Integer.parseInt(sameRelaSubstring));
        model.addAttribute("sameRelaStandardLeft", sameRelaStandardLeft);
        model.addAttribute("sameRelaStandardRight", sameRelaStandardRight);


        String edgeHeig = bearQuality.getEdgeHeig();
        String edgeHeigSubstring = edgeHeig.substring(1);
        double edgeHeigStandardRight = Double.parseDouble(edgeHeigSubstring);
        double edgeHeigStandardLeft = Math.negateExact(Integer.parseInt(edgeHeigSubstring));
        model.addAttribute("edgeHeigStandardLeft", edgeHeigStandardLeft);
        model.addAttribute("edgeHeigStandardRight", edgeHeigStandardRight);



        String crossLineTors = bearQuality.getCrossLineTors();
        String crossLineTorsSubstring = crossLineTors.substring(1);
        double crossLineTorsStandardRight = Double.parseDouble(crossLineTorsSubstring);
        double crossLineTorsStandardLeft = Math.negateExact(Integer.parseInt(crossLineTorsSubstring));
        model.addAttribute("crossLineTorsStandardLeft", crossLineTorsStandardLeft);
        model.addAttribute("crossLineTorsStandardRight", crossLineTorsStandardRight);



        String actiVert = bearQuality.getActiVert();
        String actiVertSubstring = actiVert.substring(1);
        double actiVertStandardRight = Double.parseDouble(actiVertSubstring);
        double actiVertStandardLeft = Math.negateExact(Integer.parseInt(actiVertSubstring));
        model.addAttribute("actiVertStandardLeft", actiVertStandardLeft);
        model.addAttribute("actiVertStandardRight", actiVertStandardRight);


    }



    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        bearingQualityService.deleteById(id);

      /*  model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/bearCrudPage/bearCrudPage";*/
        return "redirect:/page/bear/show";
    }




    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
    @ResponseBody
    public List<String> deleteBearMore(HttpServletRequest request,
                                              Model model,
                                              @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                bearingQualityService.deleteById(Integer.parseInt(id));

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
    public String editBear(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        BearingQuality bear = bearingQualityService.selectByPrimaryKey(id);
        model.addAttribute("bear", bear);
        return "page/bearCrudPage/bearEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updateBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

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
       // BearingQuality bear = bearingQualityService.selectByPrimaryKey(Integer.parseInt(id));
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
        bearingQuality.setBearingqualityCheckTime(new Date());

        //修改数据后要重新质量验收
        bearingQuality.setIsQualify(-1);

        bearingQualityService.updateByPrimaryKey(bearingQuality);

       /* //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/bearCrudPage/bearCrudPage";*/
        return "redirect:/page/bear/show";
    }

    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addBear(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

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
      /*  model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/bearCrudPage/bearCrudPage";*/

        return "redirect:/page/bear/show";

    }

    /**
     * 搜索
     */
    @RequestMapping(value = "/search")
    public String searchName(HttpServletRequest request,
                          Model model,
                          @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "120") Integer pageSize) {
        getRedShow(model);
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<BearingQuality> bearingQualityList = bearingQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/bearCrudPage/bearCrudPage";
    }



    /**
     * 已经验收页面搜索
     */
    @RequestMapping(value = "/qualitySearch")
    public String qualitySearchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "120") Integer pageSize) {

        getRedShow(model);
        //取值
        String name = request.getParameter("qualitySearch");
        model.addAttribute("search", name);
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
                                    @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                    @RequestParam(required = false, defaultValue = "120") Integer pageSize) {

        getRedShow(model);
        //取值
        String name = request.getParameter("notQualitySearch");
        model.addAttribute("search", name);
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
    public Map getChart(HttpServletRequest request,
                        Model model) {



        Map results = new HashMap();
        String start = request.getParameter("start");
        start = start + "  00:00:00";
        String end = request.getParameter("end");
        end = end + "  23:59:59";
        try {
            List<EntityCountDateList> lists = bearingQualityService.getIsQualityCountByDate(start, end);
            int notPassCount = bearingQualityService.selectCountByDate(start, end, 0);
            int passCount = bearingQualityService.selectCountByDate(start, end, 1);
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

        return "page/chartsPage/bearPassRate";
    }


    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/addData")
    public String addData(HttpServletRequest request,
                             Model model) {

        return "page/bearCrudPage/bearAddPage";
    }




    @RequestMapping(value = "/getSearch")
    public String getSearch(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "120") Integer pageSize) {

        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        PageInfo<BearingQuality> bearingQualityPageInfo = bearingQualityService.selectByDateAll(startTime, endTime, pageIndex, pageSize);


        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");


        model.addAttribute("pageInfo", bearingQualityPageInfo);
        return "page/bearCrudPage/bearCrudPage";

    }


    /**
     * 根据日期查找
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



        PageInfo<BearingQuality> bearQualityPageInfo = bearingQualityService.selectByDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/page/bear/getSearch?pageIndex");
        model.addAttribute("pageInfo", bearQualityPageInfo);
        return "page/chartsPage/bearChartPage";

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
                                   @RequestParam(required = false, defaultValue = "120") Integer pageSize){

        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/bear?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectQualityByDate(-1,startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/bearQuality";

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
                                      @RequestParam(required = false, defaultValue = "120") Integer pageSize){

        getRedShow(model);
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectHasQualityByDate(startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";

    }




    /**
     * 批量不合格
     *
     */
    @RequestMapping(value = "/notQualityMore")
    @ResponseBody
    public List<String> notQualityBearMore(HttpServletRequest request,
                                           Model model,
                                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                bearingQualityService.updateByIsQualify(0, Integer.parseInt(id));
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
    public List<String> qualityBearMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                bearingQualityService.updateByIsQualify(1, Integer.parseInt(id));
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

        BearingQuality bearingQuality = bearingQualityService.selectByPrimaryKey(id);

        if (bearingQuality.getIsQualify() == 1) {
            //1代表合格，更改为不合格
            bearingQualityService.updateByIsQualify(0, id);

        } else if (bearingQuality.getIsQualify() == 0){
            // //0代表不合格，1代表合格
            bearingQualityService.updateByIsQualify(1, id);

        }

        /*model.addAttribute("pageUrlPrefix", "/page/bear/hasQuality?pageIndex");
        PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityInfo);
        return "page/qualityPage/hasBearQuality";*/
        return "redirect:/page/bear/hasQuality";

    }




}