package com.newland.show.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**

 * @author zhengfawei

 * @create 2018-04-03 下午2:28

 * @desc

 **/
public class FastjsonUtil {



    public static Object textToJson(String text) {
        Object objectJson  = JSON.parse(text);
        return objectJson;
    }

    /**
     * json字符串转化为map
     * @param s
     * @return
     */
    public static Map stringTomap(String s) {
        Map m = (Map) JSONObject.parseObject(s);
        return m;
    }

    /**
     * 将map转化为string
     * @param m
     * @return
     */
    public static String mapToString(Map m) {
        String s = JSONObject.toJSONString(m);
        return s;
    }
    /**
     * list
     * @param list
     * @return
     */
    public static String listToString(List list) {
        String s = JSONObject.toJSONString(list);
        return s;
    }
}
