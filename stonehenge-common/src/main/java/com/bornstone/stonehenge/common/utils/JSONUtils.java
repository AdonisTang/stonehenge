package com.bornstone.stonehenge.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king on 16-4-25.
 */
public class JSONUtils {
    public static String getJsonStr(Object obj, boolean format) {
        if (!format) {
            return JSON.toJSONString(obj);
        }

        return JSON.toJSONString(obj, format);
    }

    public static String getJsonStr(Object obj) {
        return getJsonStr(obj, false);
    }

    public static String getFormatJsonStr(Object obj) {
        return getJsonStr(obj, true);
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<String>();
        arr.add("1");
        arr.add("2");

        System.out.println(getJsonStr(arr));
        System.out.println(getFormatJsonStr(arr));
    }
}
