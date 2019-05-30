package com.dreamaple.spbdemo.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

public class SpringUtils {
    //MD5 加料
    private static final String slat = "%@J#%&GSG*&G$JK542";
    //spring自带MD5加密
    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    public static String getVerification(){
        //生成6位随机数字
        int i = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(i);
    }

    public static JSONObject getReturn(String res, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", res);
        jsonObject.put("msg", msg);
        return jsonObject;
    }
    public static JSONObject getReturn(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res", "0");
        jsonObject.put("msg", msg);
        return jsonObject;
    }
}
