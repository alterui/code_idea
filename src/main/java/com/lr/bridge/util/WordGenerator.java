package com.lr.bridge.util;

/**
 * Created by ALTERUI on 2019/4/9 21:15
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGenerator {
    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

    static {


        try {
            Configuration cfg = new Configuration();
            cfg.setDefaultEncoding("utf-8");
            TemplateLoader templateLoader=null;
            String path="";

            //使用FileTemplateLoader
            templateLoader=new FileTemplateLoader(new File("D:\\code\\bridge\\src\\main\\webapp\\static\\ftl"));
            /*path="resume.ftl";*/
            cfg.setTemplateLoader(templateLoader);
            allTemplates = new HashMap<>();
            //可以放很多
            allTemplates.put("resume", cfg.getTemplate("resume.ftl"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private WordGenerator() {
        throw new AssertionError();
    }

    public static File createDoc(Map<?, ?> dataMap, String type) {
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";
        File file = new File(name);
        Template t = allTemplates.get(type);
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return file;
    }

}
