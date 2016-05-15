package com.bornstone.stonehenge.common.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p><b>类名称：</b>MD5Util </p>
 * <p><b>类描述：</b>对传入的字符串进行MD5加密后返回密文，只能加密成16位或者32位的密文</p>
 * <p><b>日期：</b>2012-11-15 上午11:27:21</p>
 * <p><b>作者：</b>唐金景</p>
 */
public class MD5Encrypt {
    private static final String DEFAULT_SALT = "p+ZwKt5TRRiQuOxl";

    /**
     * <p><b>作用：</b>可设置加密位数 的 加密（可选位数：16，32）</p>
     * <p><b>日期：</b>2009-12-15 上午11:28:13</p>
     * <p><b>作者：</b>唐金景</p>
     *
     * @param plainText 需要加密的明文
     * @param isFull    是否需要加密为32位
     * @return
     * @throws
     */
    private static final String encrypt(String plainText, Boolean isFull) {
        String resultStr = ""; // 加密结果字符
        MessageDigest md = null; // 加密类声明
        byte rSArr[]; // 加密后的密文数组
        int theBitNum; // 单个密文
        StringBuffer md5Str = new StringBuffer(""); // 加密后的密文字符串

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("utf-8"));
            rSArr = md.digest();

            for (int offset = 0; offset < rSArr.length; offset++) {
                theBitNum = rSArr[offset];
                if (theBitNum < 0) {
                    theBitNum += 256;
                }
                if (theBitNum < 16) {
                    md5Str.append("0");
                }
                md5Str.append(Integer.toHexString(theBitNum));
            }
            // 32位直接返回，16位需要截取字符
            resultStr = isFull ? md5Str.toString() : md5Str
                    .toString().substring(8, 24);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

    /**
     * <p><b>作用：</b>16位加密</p>
     * <p><b>日期：</b>2009-12-15 上午11:28:13</p>
     * <p><b>作者：</b>唐金景</p>
     *
     * @param plainText 需要加密的明文
     * @return
     * @throws
     */
    public static final String encryptSub(String plainText) {
        return encrypt(plainText, false);
    }

    /**
     * <p><b>作用：</b>32位加密</p>
     * <p><b>日期：</b>2009-12-15 上午11:28:13</p>
     * <p><b>作者：</b>唐金景</p>
     *
     * @param plainText 需要加密的明文
     * @return
     * @throws
     */
    public static final String encrypt(String plainText) {
        return encrypt(plainText, true);
    }

    /**
     * @param plainText
     * @param salt
     * @return String
     * @Description:使用salt进行加密
     * @Date:2012-11-16 下午9:24:30
     * @since 1.0.0
     */
    public static final String encryptWithSalt(String plainText, String salt) {
        try {
            byte[] b = MessageDigest.getInstance("MD5").digest((plainText + salt).getBytes());
            StringBuffer buf = new StringBuffer("");
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            return buf.toString().substring(4, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 使用默认的Salt加密
     *
     * @param plaintText
     * @return
     */
    public static final String encryptWithSalt(String plaintText) {
        return encryptWithSalt(plaintText, DEFAULT_SALT);
    }
}