package com.bornstone.stonehenge.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author woodbird
 * @since 2012-11-10
 */
public class AttributeUtil {

    public static String getAttribute(String attributes, String key) {
        if (StringUtils.isEmpty(attributes) || StringUtils.isEmpty(key)) {
            return null;
        } else {
            String[] pairs = attributes.split(";");
            for (String pair : pairs) {
                String[] key_value = pair.split(":");
                if (key.equals(key_value[0])) {
                    if (StringUtils.isEmpty(key_value[1])) {
                        return null;
                    }
                    return key_value[1];
                }
            }
            return null;
        }
    }

    public static String addAttribute(String attributes, String key, String value) {
        StringBuilder newAttributes = new StringBuilder();
        boolean isAdd = false;
        if (null == attributes) {
            attributes = "";
        }
        String[] pairs = attributes.split(";");
        for (String pair : pairs) {
            if (StringUtils.isEmpty(pair)) {
                continue;
            }
            String[] key_value = pair.split(":");
            if (key_value.length != 2) {
                continue;
            }
            if (key.equals(key_value[0])) {
                newAttributes.append(key);
                newAttributes.append(":");
                newAttributes.append(value);
                newAttributes.append(";");
                isAdd = true;
            } else {
                newAttributes.append(key_value[0]);
                newAttributes.append(":");
                newAttributes.append(key_value[1]);
                newAttributes.append(";");
            }
        }
        if (!isAdd) {
            newAttributes.append(key);
            newAttributes.append(":");
            newAttributes.append(value);
            if (!StringUtils.isEmpty(newAttributes.toString())) {
                newAttributes.append(";");
            }
        }
        return newAttributes.toString();
    }

    public static Map<String, String> convert2Map(String attributes) {
        Map<String, String> map = new HashMap<String, String>();
        String[] pairs = attributes.split(";");
        for (String pair : pairs) {
            String[] key_value = pair.split(":");
            if (key_value.length == 2) {
                if (StringUtils.isNotEmpty(key_value[0]) && StringUtils.isNotEmpty(key_value[1])) {
                    map.put(key_value[0], key_value[1]);
                }
            }
        }
        return map;
    }

}
