package com.lr.bridge.controller;

import com.github.pagehelper.PageInfo;

import com.lr.bridge.pojo.EnvProtection;
import com.lr.bridge.service.EnvProtectionService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ALTERUI on 2019/4/9 17:34
 */

@Controller
@RequestMapping("/page/env")
public class EnvProtectionController {


    @Resource
    private EnvProtectionService envProtectionService;


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
        model.addAttribute("pageUrlPrefix", "/page/bear/show?pageIndex");
        PageInfo<EnvProtection> EnvProtectionInfo = envProtectionService.showEnvProtection(pageIndex,pageSize);

        try {
            model.addAttribute("pageInfo", EnvProtectionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return "page/envProtectionPage/reportForm";

    }


    /**
     * 取值显示在页面上
     *
     * @param id
     */
    @RequestMapping(value = "/saveDoc/{id}")
    public void saveDoc(HttpServletRequest request,
                           HttpServletResponse resp,
                           Model model,
                           @PathVariable("id") Integer id) {

        EnvProtection envProtection = envProtectionService.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        map.put("cbdw", envProtection.getCbdw());
        map.put("bdh", envProtection.getBdh());
        map.put("jldw", envProtection.getJldw());
        map.put("shbmz", envProtection.getSqbmz());
        map.put("bh", envProtection.getBh());
        map.put("zjb", envProtection.getZjb());
        map.put("gcmz", envProtection.getGcmz());




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
            // 设置浏览器以下载的方式处理该文件默认名为resume.doc
            resp.addHeader("Content-Disposition", "attachment;filename=resume.doc");

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
