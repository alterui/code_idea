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
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                       @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                       @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        //得到所有的申请表
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<ApplyAndReply> applyAndReplyPageInfo = applyAndReplyService.showAllApplyAndReply(pageIndex,pageSize);

        try {
            model.addAttribute("pageInfo", applyAndReplyPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "page/applyAndReportPage/reportForm";

    }
    /**
     * 取值显示在页面上
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
        Date applicationTime = applyAndReply.getApplicationTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(applicationTime);

        String[] split = date.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        /*System.out.println(year + month + day);*/
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

}
