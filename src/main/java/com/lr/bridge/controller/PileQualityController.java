package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.PileQuality;
import com.lr.bridge.service.PileQualityService;
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
@RequestMapping("/page/pile")
public class PileQualityController {
	
	@Resource
	private PileQualityService pileQualityService;
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
        model.addAttribute("pageUrlPrefix", "/page/pile?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/pileQuality";

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

        model.addAttribute("pageUrlPrefix", "/page/pile/hasQuality?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/hasPileQuality";

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
        pileQualityService.updateByIsQualify(1, id);

       /* model.addAttribute("pageUrlPrefix", "/page/pile?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/pileQuality";*/
        return "redirect:/page/pile/";

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
        pileQualityService.updateByIsQualify(0, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/pile?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/pileQuality";*/
        return "redirect:/page/pile/";

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
        pileQualityService.updateByIsQualify(1, id);

      /*  model.addAttribute("pageUrlPrefix", "/page/pile/hasQuality?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/hasPileQuality";*/
        return "redirect:/page/pile/hasQuality";

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
        pileQualityService.updateByIsQualify(0, id);

       /* model.addAttribute("pageUrlPrefix", "/page/pile/hasQuality?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/hasPileQuality";*/

        return "redirect:/page/pile/hasQuality";
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

        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showPile(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/pileCrudPage/pileCrudPage";

    }



    private void getRedShow(Model model) {
        PileQuality pileQuality = pileQualityService.selectByPrimaryKey(1);



        model.addAttribute("pileDeviStandard", Double.parseDouble(pileQuality.getPileDevi()));
        model.addAttribute("sediThiDeviStandard", Double.parseDouble(pileQuality.getSediThiDevi()));


        String vertDevi = pileQuality.getVertDevi();
        String vertDeviSubstring = vertDevi.substring(1);
        double vertDeviStandardRight = Double.parseDouble(vertDeviSubstring);
        double vertDeviStandardLeft = Math.negateExact(Integer.parseInt(vertDeviSubstring));
        model.addAttribute("vertDeviStandardLeft", vertDeviStandardLeft);
        model.addAttribute("vertDeviStandardRight", vertDeviStandardRight);

        model.addAttribute("holeDepthDeviStandard", Double.parseDouble(pileQuality.getHoleDepthDevi()));



        String aperDevi = pileQuality.getAperDevi();
        String aperDeviSubstring = aperDevi.substring(1);
        double aperDeviStandardRight = Double.parseDouble(aperDeviSubstring);
        double aperDeviStandardLeft = Math.negateExact(Integer.parseInt(aperDeviSubstring));
        model.addAttribute("aperDeviStandardLeft", aperDeviStandardLeft);
        model.addAttribute("aperDeviStandardRight", aperDeviStandardRight);


        model.addAttribute("mudPropDeviStandard", Double.parseDouble(pileQuality.getMudPropDevi()));



        String mudSurfDevi = pileQuality.getMudSurfDevi();
        String mudSurfDeviSubstring = mudSurfDevi.substring(1);
        double mudSurfDeviStandardRight = Double.parseDouble(mudSurfDeviSubstring);
        double mudSurfDeviStandardLeft = Math.negateExact(Integer.parseInt(mudSurfDeviSubstring));
        model.addAttribute("mudSurfDeviStandardLeft", mudSurfDeviStandardLeft);
        model.addAttribute("mudSurfDeviStandardRight", mudSurfDeviStandardRight);



        model.addAttribute("rebarDeviStandard", Double.parseDouble(pileQuality.getRebarDevi()));


        String conctre = pileQuality.getConctre();
        String conctreSubstring = conctre.substring(1);
        double conctreStandardRight = Double.parseDouble(conctreSubstring);
        double conctreStandardLeft = Math.negateExact(Integer.parseInt(conctreSubstring));
        model.addAttribute("conctreStandardLeft", conctreStandardLeft);
        model.addAttribute("conctreStandardRight", conctreStandardRight);



        model.addAttribute("fillingFactorStandard", Double.parseDouble(pileQuality.getFillingFactor()));


        String pileTopDevi = pileQuality.getPileTopDevi();
        String pileTopDeviSubstring = pileTopDevi.substring(1);
        double pileTopDeviStandardRight = Double.parseDouble(pileTopDeviSubstring);
        double pileTopDeviStandardLeft = Math.negateExact(Integer.parseInt(pileTopDeviSubstring));
        model.addAttribute("pileTopDeviStandardLeft", pileTopDeviStandardLeft);
        model.addAttribute("pileTopDeviStandardRight", pileTopDeviStandardRight);



    }


    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deletePile(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        pileQualityService.deleteById(id);

       /* model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showPile(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/pileCrudPage/pileCrudPage";*/
        return "redirect:/page/pile/show";
    }


    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/edit/{id}")
    public String editPile(HttpServletRequest request,
                             Model model,
                             @PathVariable("id") Integer id) {

        PileQuality pile = pileQualityService.selectByPrimaryKey(id);
        model.addAttribute("pile", pile);
        return "page/pileCrudPage/pileEditPage";
    }


    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updatePile(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PileQuality pileQuality = new PileQuality();



        //保存
        pileQuality.setId(Integer.parseInt(request.getParameter("id")));

        pileQuality.setStruId(request.getParameter("struId"));
        pileQuality.setPileDevi(request.getParameter("pileDevi"));
        pileQuality.setSediThiDevi(request.getParameter("sediThiDevi"));
        pileQuality.setVertDevi(request.getParameter("vertDevi"));
        pileQuality.setHoleDepthDevi(request.getParameter("holeDepthDevi"));
        pileQuality.setAperDevi(request.getParameter("aperDevi"));
        pileQuality.setMudPropDevi(request.getParameter("mudPropDevi"));
        pileQuality.setMudSurfDevi(request.getParameter("mudSurfDevi"));
        pileQuality.setRebarDevi(request.getParameter("rebarDevi"));
        pileQuality.setConctre(request.getParameter("conctre"));
        pileQuality.setFillingFactor(request.getParameter("fillingFactor"));
        pileQuality.setPileTopDevi(request.getParameter("pileTopDevi"));

        //修改表明重新测量，时间更新
        pileQuality.setPilequalityCheckTime(new Date());

        //修改数据后要重新质量验收
        pileQuality.setIsQualify(-1);

        pileQualityService.updateByPrimaryKey(pileQuality);

       /* //show
        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showPile(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/pileCrudPage/pileCrudPage";*/
        return "redirect:/page/pile/show";
    }

    /**
     * 增加一条数据
     */
    @RequestMapping(value = "/add")
    public String addPile(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        PileQuality pileQuality = new PileQuality();

        //保存
        pileQuality.setStruId(request.getParameter("struId"));

        pileQuality.setPileDevi(request.getParameter("pileDevi"));
        pileQuality.setSediThiDevi(request.getParameter("sediThiDevi"));
        pileQuality.setVertDevi(request.getParameter("vertDevi"));
        pileQuality.setHoleDepthDevi(request.getParameter("holeDepthDevi"));
        pileQuality.setAperDevi(request.getParameter("aperDevi"));
        pileQuality.setMudPropDevi(request.getParameter("mudPropDevi"));
        pileQuality.setMudSurfDevi(request.getParameter("mudSurfDevi"));
        pileQuality.setRebarDevi(request.getParameter("rebarDevi"));
        pileQuality.setConctre(request.getParameter("conctre"));
        pileQuality.setFillingFactor(request.getParameter("fillingFactor"));
        pileQuality.setPileTopDevi(request.getParameter("pileTopDevi"));



        pileQuality.setPilequalityCheckTime(new Date());
        pileQuality.setIsQualify(-1);
        pileQualityService.insert(pileQuality);
        //show
       /* model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.showPile(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/pileCrudPage/pileCrudPage";*/
        return "redirect:/page/pile/show";
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
        PageInfo<PileQuality> pileQualityList = pileQualityService.selectByLikeName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        //PageInfo<pileQuality> pileQualityInfo = pileQualityService.showPile(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityList);
        return "page/pileCrudPage/pileCrudPage";
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
        PageInfo<PileQuality> pileQualityList = pileQualityService.selectByLikeNameAndQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        model.addAttribute("pageInfo", pileQualityList);
        return "page/qualityPage/hasPileQuality";
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
        PageInfo<PileQuality> pileQualityList = pileQualityService.selectByLikeNameAndNotQuality(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");
        model.addAttribute("pageInfo", pileQualityList);
        return "page/qualityPage/pileQuality";
    }




    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/pileStandard")
    public String pileStandard(HttpServletRequest request,
                           Model model) {

        //标准值Id默认为1
        PileQuality pile = pileQualityService.selectByPrimaryKey(1);
        model.addAttribute("pile", pile);
        return "page/standardPage/pileStandard";
    }



    /**
     * 修改标准值
     */
    @RequestMapping(value = "/updateStandard")
    public String updatePileStandard(HttpServletRequest request,
                             Model model) {




        PileQuality pileQuality = new PileQuality();
        PileQuality pile = pileQualityService.selectByPrimaryKey(1);
        //保存
        pileQuality.setId(1);
        pileQuality.setStruId("标准值");


        pileQuality.setPileDevi(request.getParameter("pileDevi"));
        pileQuality.setSediThiDevi(request.getParameter("sediThiDevi"));
        pileQuality.setVertDevi(request.getParameter("vertDevi"));
        pileQuality.setHoleDepthDevi(request.getParameter("holeDepthDevi"));
        pileQuality.setAperDevi(request.getParameter("aperDevi"));
        pileQuality.setMudPropDevi(request.getParameter("mudPropDevi"));
        pileQuality.setMudSurfDevi(request.getParameter("mudSurfDevi"));
        pileQuality.setRebarDevi(request.getParameter("rebarDevi"));
        pileQuality.setConctre(request.getParameter("conctre"));
        pileQuality.setFillingFactor(request.getParameter("fillingFactor"));
        pileQuality.setPileTopDevi(request.getParameter("pileTopDevi"));

        //标准值特有为2
        pileQuality.setIsQualify(2);

        pileQuality.setPilequalityCheckTime(new Date());

        pileQualityService.updateByPrimaryKey(pileQuality);

        //回显
        //标准值Id默认为1
        PileQuality pileStandard = pileQualityService.selectByPrimaryKey(1);
        model.addAttribute("pile", pileStandard);
        return "page/standardPage/pileStandard";

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
            List<EntityCountDateList> lists = pileQualityService.getIsQualityCountByDate(start, end);
            int notPassCount = pileQualityService.selectCountByDate(start, end, 0);
            int passCount = pileQualityService.selectCountByDate(start, end, 1);
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

        return "page/chartsPage/pilePassRate";
    }


    /**
     * 取值显示在验收标准页面上
     */
    @RequestMapping(value = "/addData")
    public String addData(HttpServletRequest request,
                             Model model) {

        return "page/pileCrudPage/pileAddPage";
    }

    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
    @ResponseBody
    public List<String> deletePileMore(HttpServletRequest request,
                                       Model model,
                                       @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                       @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");

        String[] split = ids.trim().split(",");

        List<String> result = new ArrayList<>();

        try {
            for (String id : split) {
                id= id.trim();

                pileQualityService.deleteById(Integer.parseInt(id));

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

        PageInfo<PileQuality> pileQualityPageInfo = pileQualityService.selectByDateAll(startTime, endTime, pageIndex, pageSize);


        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/pile/show?pageIndex");


        model.addAttribute("pageInfo", pileQualityPageInfo);
        return "page/pileCrudPage/pileCrudPage";

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

        model.addAttribute("pageUrlPrefix", "/page/pile?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectQualityByDate(-1,startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/pileQuality";

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

        model.addAttribute("pageUrlPrefix", "/page/pile/hasQuality?pageIndex");
        //-1表示没有确认的。0代表不合格，1代表合格
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectHasQualityByDate(startTime,endTime,pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/hasPileQuality";

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



        PageInfo<PileQuality> pileQualityPageInfo = pileQualityService.selectByDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageUrlPrefix", "/page/pile/getSearch?pageIndex");
        model.addAttribute("pageInfo", pileQualityPageInfo);
        return "page/chartsPage/pileChartPage";

    }





    /**
     * 批量不合格
     *
     */
    @RequestMapping(value = "/notQualityMore")
    @ResponseBody
    public List<String> notQualityPileMore(HttpServletRequest request,
                                           Model model,
                                           @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                pileQualityService.updateByIsQualify(0, Integer.parseInt(id));
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
    public List<String> qualityPileMore(HttpServletRequest request,
                                        Model model,
                                        @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        String ids = request.getParameter("id");
        String[] split = ids.trim().split(",");
        List<String> result = new ArrayList<>();
        try {
            for (String id : split) {
                id= id.trim();
                pileQualityService.updateByIsQualify(1, Integer.parseInt(id));
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

        PileQuality pileQuality = pileQualityService.selectByPrimaryKey(id);

        if (pileQuality.getIsQualify() == 1) {
            //1代表合格，更改为不合格
            pileQualityService.updateByIsQualify(0, id);

        } else if (pileQuality.getIsQualify() == 0){
            // //0代表不合格，1代表合格
            pileQualityService.updateByIsQualify(1, id);

        }

      /*  model.addAttribute("pageUrlPrefix", "/page/pile/hasQuality?pageIndex");
        PageInfo<PileQuality> pileQualityInfo = pileQualityService.selectByHasQuality(pageIndex, pageSize);
        model.addAttribute("pageInfo", pileQualityInfo);
        return "page/qualityPage/hasPileQuality";*/
        return "redirect:/page/pile/hasQuality";

    }




}