package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.ApplyAndReply;
import com.lr.bridge.service.ApplyAndReplyService;
import com.lr.bridge.util.MD5Util;
import com.lr.bridge.util.WordGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ALTERUI on 2019/4/9 17:34
 */

@Controller
@RequestMapping("/page/apply")
public class ApplyAndReplyController {

    @Resource
    private ApplyAndReplyService applyAndReplyService;
    /**
     * 申请审批表显示数据
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
        //得到所有的申请表
        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showAllApplyAndReply(pageIndex,pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/reportForm";

    }
    /**
     * doc下载，公用
     *
     * @param id
     */
    @RequestMapping(value = "/downloadDoc/{id}")
    public void saveDoc(HttpServletRequest request,
                           HttpServletResponse resp,
                           Model model,
                           @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();

        map.put("contractorUnit", applyAndReply.getContractorUnit());
        map.put("bidNum", applyAndReply.getBidNum());
        map.put("supervision", applyAndReply.getSupervision());
        map.put("serialNum", applyAndReply.getSerialNum());
        map.put("formName", applyAndReply.getFormName());
        map.put("director", applyAndReply.getDirector());
        map.put("projectName", applyAndReply.getProjectName());
        map.put("contractorName", applyAndReply.getContractorName());

        if (applyAndReply.getDirectorView() != null) {
            map.put("directorView", applyAndReply.getDirectorView());
        }else {
            map.put("directorView", " ");
        }


        if (applyAndReply.getCenterView() != null) {
            map.put("centerView", applyAndReply.getCenterView());
        }else {
            map.put("centerView", " ");
        }

        if (applyAndReply.getCenterName() != null) {
            map.put("centerName", applyAndReply.getCenterName());
        } else {
            map.put("centerName", " ");
        }



        Date applicationTime = applyAndReply.getApplicationTime();
        Date centerReplyTime = applyAndReply.getCenterReplyTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(applicationTime);


        String[] split = date.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];


        if (centerReplyTime != null) {
            String date1 = simpleDateFormat.format(centerReplyTime);

            String[] split1 = date1.split("-");
            String year1 = split1[0];
            String month1 = split1[1];
            String day1 = split1[2];
            map.put("year1", year1);
            map.put("month1", month1);
            map.put("day1", day1);
        } else {
            map.put("year1", "           ");
            map.put("month1", "  ");
            map.put("day1", "  ");
        }

        map.put("year", year);
        map.put("month", month);
        map.put("day", day);

        // 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
        // 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类WordGenerator的createDoc方法生成Word文档
            file = WordGenerator.createDoc(map, "resume");
            fin = new FileInputStream(file);

            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/msword");
            Random random = new Random();
            String res = MD5Util.getMD5(String.valueOf(random.nextInt(1000)));
            //System.out.println(res);
            res = res.substring(0, 15);
            // 设置浏览器以下载的方式处理该文件默认名为resume.doc
            resp.addHeader("Content-Disposition", "attachment;filename="+res+".doc");

            out = resp.getOutputStream();
            byte[] buffer = new byte[512];	// 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fin != null) fin.close();
                if(out != null) out.close();
                if(file != null) file.delete();	// 删除临时文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * 用户的未审核预览
     * @param request
     * @param resp
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/previewForm/{id}")
    public String previewForm(HttpServletRequest request,
                        HttpServletResponse resp,
                        Model model,
                        @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        model.addAttribute("apply", applyAndReply);
        return "page/applyAndReportPage/previewForm";


    }


    /**
     * 添加数据页面
     * @param request
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/addPage")
    public String addPage(HttpServletRequest request,
                          HttpServletResponse resp,
                          Model model) {


        return "page/applyAndReportPage/writeForm";


    }

    /**
     * 添加数据
     * @param request
     * @param resp
     * @param model
     * @param session
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request,
                      HttpServletResponse resp,
                      Model model,
                      HttpSession session,
                      @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                      @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        ApplyAndReply applyAndReply = new ApplyAndReply();

        applyAndReply.setContractorUnit(request.getParameter("contractorUnit"));
        applyAndReply.setBidNum(request.getParameter("bidNum"));
        applyAndReply.setSupervision(request.getParameter("supervision"));
        applyAndReply.setSerialNum(request.getParameter("serialNum"));
        applyAndReply.setFormName(request.getParameter("formName"));
        applyAndReply.setDirector(request.getParameter("director"));
        applyAndReply.setProjectName(request.getParameter("projectName"));
        applyAndReply.setDirectorView(request.getParameter("directorView"));

        applyAndReply.setContractorName((String) session.getAttribute("userName"));
        applyAndReply.setApplicationTime(new Date());

        applyAndReplyService.insert(applyAndReply);

        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showAllApplyAndReply(pageIndex,pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/reportForm";

    }



    /**
     * 删除
     *
     * @param id
     */
    @RequestMapping(value = "/delete/{id}")
    public String deleteApply(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             @PathVariable("id") Integer id) {

        applyAndReplyService.deleteByPrimaryKey(id);

        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyInfo = applyAndReplyService.showAllApplyAndReply(pageIndex, pageSize);
        model.addAttribute("pageInfo", applyAndReplyInfo);
        return "page/applyAndReportPage/reportForm";
    }


    /**
     * 批量删除
     *
     */
    @RequestMapping(value = "/deleteMore")
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

                applyAndReplyService.deleteByPrimaryKey(Integer.parseInt(id));

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
    public String editApply(HttpServletRequest request,
                           Model model,
                           @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        model.addAttribute("apply", applyAndReply);
        return "page/applyAndReportPage/editForm";
    }



    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    public String updateApply(HttpServletRequest request,
                             Model model,
                             HttpSession session,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        ApplyAndReply applyAndReply = new ApplyAndReply();


        applyAndReply.setId(Integer.parseInt(request.getParameter("id")));
        applyAndReply.setContractorUnit(request.getParameter("contractorUnit"));
        applyAndReply.setBidNum(request.getParameter("bidNum"));
        applyAndReply.setSupervision(request.getParameter("supervision"));
        applyAndReply.setSerialNum(request.getParameter("serialNum"));
        applyAndReply.setFormName(request.getParameter("formName"));
        applyAndReply.setDirector(request.getParameter("director"));
        applyAndReply.setProjectName(request.getParameter("projectName"));
        applyAndReply.setDirectorView(request.getParameter("directorView"));

        applyAndReply.setContractorName((String) session.getAttribute("userName"));
        applyAndReply.setApplicationTime(new Date());

        applyAndReplyService.updateByPrimaryKey(applyAndReply);

        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showAllApplyAndReply(pageIndex,pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/reportForm";



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



        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.selectByDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/reportForm";

    }


    /**
     * 显示待审核的回执单
     * @param request
     * @param resp
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/showCheck")
    public String checkPage(HttpServletRequest request,
                          HttpServletResponse resp,
                          Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        //得到所有的没有回复的回执单
        model.addAttribute("pageUrlPrefix", "/page/apply/showCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showNotAudit(pageIndex, pageSize);

        model.addAttribute("pageInfo", applyAndReplyPageInfo);

        return "page/applyAndReportPage/auditForm";



    }


    /**
     * 显示已经审核的回执单
     * @param request
     * @param resp
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/showHasCheck")
    public String hasCheckPage(HttpServletRequest request,
                            HttpServletResponse resp,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        //得到所有已经回复的回执单
        model.addAttribute("pageUrlPrefix", "/page/apply/showHasCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showHasAudit(pageIndex, pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/hasAuditForm";

    }


    /**
     * 跳转到审核页面
     * @param request
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/audit/{id}")
    public String auditPage(HttpServletRequest request,
                            HttpServletResponse resp,
                            Model model,
                            @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        model.addAttribute("apply", applyAndReply);
        return "page/applyAndReportPage/replyForm";

    }


    /**
     * 跳转到修改审核页面
     * @param request
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateAudit/{id}")
    public String updateAuditPage(HttpServletRequest request,
                            HttpServletResponse resp,
                            Model model,
                            @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        model.addAttribute("apply", applyAndReply);
        return "page/applyAndReportPage/updateReplyForm";

    }


    /**
     * 审核之后跳转页面
     * @param request
     * @param resp
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/replyFrom")
    public String replyFrom(HttpServletRequest request,
                            HttpServletResponse resp,
                            HttpSession session,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        String id = request.getParameter("id");
        String centerView = request.getParameter("centerView");
        String centerName = (String)session.getAttribute("userName");


        applyAndReplyService.updateByViewAndDate(centerName,centerView,new Date(), Integer.parseInt(id));

        //得到所有的没有回复的回执单
        model.addAttribute("pageUrlPrefix", "/page/apply/showCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showNotAudit(pageIndex, pageSize);

        model.addAttribute("pageInfo", applyAndReplyPageInfo);

        return "page/applyAndReportPage/auditForm";

    }


    /**
     * 修改审核意见之后跳转页面
     * @param request
     * @param resp
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/hasReplyFrom")
    public String hasReplyFrom(HttpServletRequest request,
                            HttpServletResponse resp,
                            HttpSession session,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {


        String id = request.getParameter("id");
        String centerView = request.getParameter("centerView");
        String centerName = (String) session.getAttribute("userName");

        applyAndReplyService.updateByViewAndDate(centerName,centerView,new Date(), Integer.parseInt(id));

        //得到所有已经回复的回执单
        model.addAttribute("pageUrlPrefix", "/page/apply/showHasCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showHasAudit(pageIndex, pageSize);

        model.addAttribute("pageInfo", applyAndReplyPageInfo);

        return "page/applyAndReportPage/hasAuditForm";

    }


    /**
     * 已经审核预览
     * @param request
     * @param resp
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/hasPreviewForm/{id}")
    public String hasPreviewForm(HttpServletRequest request,
                              HttpServletResponse resp,
                              Model model,
                              @PathVariable("id") Integer id) {

        ApplyAndReply applyAndReply = applyAndReplyService.selectByPrimaryKey(id);
        model.addAttribute("apply", applyAndReply);
        return "page/applyAndReportPage/centerPreviewForm";


    }



    /**
     * 所有数据的页面
     * 关键字搜索
     */
    @RequestMapping(value = "/searchAll")
    public String searchName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<ApplyAndReply> bearingQualityList = applyAndReplyService.selectByAllFormName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/apply/show?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/applyAndReportPage/reportForm";
    }


    /**
     * 待审核页面
     * 关键字搜索
     */
    @RequestMapping(value = "/searchAudit")
    public String searchAuditName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<ApplyAndReply> bearingQualityList = applyAndReplyService.selectByAuditFormName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/apply/showCheck?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/applyAndReportPage/auditForm";
    }


    /**
     * 已经审核页面
     * 关键字搜索
     */
    @RequestMapping(value = "/searchHasAudit")
    public String searchHasAuditName(HttpServletRequest request,
                             Model model,
                             @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        //取值
        String name = request.getParameter("search");
        model.addAttribute("search", name);
        PageInfo<ApplyAndReply> bearingQualityList = applyAndReplyService.selectByHasAuditFormName(name, pageIndex, pageSize);
        //show
        model.addAttribute("pageUrlPrefix", "/page/apply/showHasCheck?pageIndex");
        //PageInfo<BearingQuality> bearingQualityInfo = bearingQualityService.showBear(pageIndex, pageSize);
        model.addAttribute("pageInfo", bearingQualityList);
        return "page/applyAndReportPage/hasAuditForm";
    }


    /**
     * 待审核页面
     * 根据日期查找
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getAuditSearch")
    public String getAuditSearch(HttpServletRequest request,
                            Model model,
                            @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";

        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/apply/showCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.selectByAuditDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/auditForm";

    }



    /**
     * 已经审核页面
     * 根据日期查找
     * @param request
     * @param model
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getHasAuditSearch")
    public String getHasAuditSearch(HttpServletRequest request,
                                 Model model,
                                 @RequestParam(required = false, defaultValue = "0") Integer pageIndex,
                                 @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        String start = request.getParameter("start");
        String startTime = start + "  00:00:00";
        String end = request.getParameter("end");
        String endTime = end + "  23:59:59";
        model.addAttribute("showStart", start);
        model.addAttribute("showEnd", end);

        model.addAttribute("pageUrlPrefix", "/page/apply/showHasCheck?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.selectByHasAuditDate(startTime, endTime, pageIndex, pageSize);
        model.addAttribute("pageInfo", applyAndReplyPageInfo);
        return "page/applyAndReportPage/hasAuditForm";

    }

}
