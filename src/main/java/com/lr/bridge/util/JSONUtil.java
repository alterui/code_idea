package com.lr.bridge.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by ALTERUI on 2019/3/27 9:04
 */
public class JSONUtil {

    public static String getJSONString(int code, Map<String,Object> map) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        return jsonObject.toJSONString();
    }
}
