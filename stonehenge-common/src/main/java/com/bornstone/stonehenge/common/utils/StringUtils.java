package com.bornstone.stonehenge.common.utils;

import java.util.Random;


/**
 * @author woodbird
 * @since 2012-11-10
 */
public class StringUtils {
    /**
     * @param oldStr 需要编码的字符串
     * @return newStr 编码后的字符串 String
     * @Description:对字符进行GBK编码
     * @Date:2012-2-28 下午5:19:36
     * @since 1.0.0
     */
    public static final String toGBK(String oldStr) {
        return conversion(oldStr, "GBK");
    }

    /**
     * @param oldStr 需要编码的字符串
     * @return newStr 编码后的字符串 String
     * @Description:对字符进行utf-8编码
     * @Date:2012-2-28 下午5:19:36
     * @since 1.0.0
     */
    public static final String toUTF8(String oldStr) {
        return conversion(oldStr, "utf-8");
    }

    /**
     * @param oldStr 需要编码的字符串
     * @param coding 编码方式
     * @return newStr 编码后的字符串 String
     * @Description:对字符进行编码
     * @Date:2012-2-28 下午5:25:53
     * @since 1.0.0
     */
    private static final String conversion(String oldStr, String coding) {
        String newStr = "";
        try {
            if (oldStr != null) {
                newStr = new String(oldStr.getBytes("ISO-8859-1"), coding);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newStr;
    }

    /**
     * @param codeCount 随机字符长度
     * @return String
     * @Description:随机产生的指定长度的随机字符
     * @Date:2012-3-1 上午10:20:05
     * @since 1.0.0
     */
    public static String createRandomCode(int codeCount) {
        return createRandomCode(codeCount, false);
    }

    /**
     * @param codeCount 随机字符长度
     * @return String
     * @Description:随机产生的指定长度的随机字符
     * @Date:2012-3-1 上午10:20:05
     * @since 1.0.0
     */
    public static String createRandomCode(int codeCount, boolean onlyDigits) {
        StringBuffer randomCode = new StringBuffer();
        Random random = new Random();

        String strRand = null;
        char[] codeSequence;
        if (onlyDigits) {
            codeSequence = new char[]{'0', '1', '2', '3', '4', '5', '6', '7',
                    '8', '9'};
        } else {
            codeSequence = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                    'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                    'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
        }
        for (int i = 0; i < codeCount; i++) {
            strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            randomCode.append(strRand);
        }

        return randomCode.toString();
    }

    /**
     * @return String
     * @Description:随机产生的4位随机字符
     * @Date:2012-3-1 上午10:20:05
     * @since 1.0.0
     */
    public static String createRandomCode() {
        return createRandomCode(4);
    }

    public static boolean isEmpty(String str) {
        if (null == str || str.length() < 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        if (null == str || str.trim().length() < 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String ellipsis(String content, int maxLength) {
        if (StringUtils.isEmpty(content) || content.length() <= maxLength) {
            return content;
        }
        return content.substring(0, maxLength) + "...";
    }

}
