package com.bornstone.stonehenge.common.utils;

import java.math.BigDecimal;

/**
 * NumberUtils.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 数字工具类
 * @Date 2012-12-17下午3:30:48
 * @since 1.0.0
 */
public class NumberUtils {
    /**
     * @param number
     * @return boolean
     * @Description:为空
     * @Date:2012-12-27 下午3:25:02
     * @since 1.0.0
     */
    public static boolean isNull(Number number) {
        return number == null;
    }

    /**
     * @param number
     * @return boolean
     * @Description:不为空
     * @Date:2012-12-27 下午3:25:15
     * @since 1.0.0
     */
    public static boolean isNotNull(Number number) {
        return number != null;
    }

    /**
     * @param id
     * @return boolean
     * @Description:不是一个合法的id
     * @Date:2012-12-17 下午3:34:27
     * @since 1.0.0
     */
    public static boolean isNotAId(Number id) {
        return isNull(id) || id.intValue() <= 0;
    }

    /**
     * @param id
     * @return boolean
     * @Description:是一个合法的id
     * @Date:2012-12-17 下午3:34:27
     * @since 1.0.0
     */
    public static boolean isAId(Number id) {
        return isNotNull(id) && id.intValue() > 0;
    }

    /**
     * @param number
     * @return boolean
     * @Description:大于0
     * @Date:2012-12-27 下午4:34:15
     * @since 1.0.0
     */
    public static boolean isMoreThanZero(Number number) {
        return isNotNull(number) && number.intValue() > 0;
    }

    /**
     * @param number
     * @param compareNum
     * @return boolean
     * @Description:是否大于指定数
     * @Date:2012-12-29 下午4:00:41
     * @since 1.0.0
     */
    public static boolean isMoreThan(Number number, Number compareNum) {
        return number.intValue() > compareNum.intValue();
    }

    /**
     * @param number
     * @param compareNum
     * @return boolean
     * @Description:是否大于等于指定数
     * @Date:2012-12-29 下午4:00:57
     * @since 1.0.0
     */
    public static boolean isMoreThanOrEql(Number number, Number compareNum) {
        return number.intValue() >= compareNum.intValue();
    }

    /**
     * @param decimal
     * @return Double
     * @Description:四舍五入 保留两位小数
     * @Date:2013-1-23 下午1:07:26
     * @since 1.0.0
     */
    public static Double round(Double decimal) {
        return round(decimal, 2);
    }

    /**
     * @param decimal
     * @param scale
     * @return Double
     * @Description:四舍五入 保留指定位小数
     * @Date:2013-3-8 下午3:40:21
     * @since 1.0.0
     */
    public static Double round(Double decimal, Integer scale) {
        BigDecimal bigDecimal = new BigDecimal(decimal);
        Double roundDecimal = bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return roundDecimal;
    }

    /**
     * @param dividend
     * @param divisor
     * @return Double
     * @Description:计算两个整数的 商（商为小数）
     * @Date:2013-1-23 下午1:07:59
     * @since 1.0.0
     */
    public static Double calculateDoubleQuotientOfTowIntegerNumber(
            Integer dividend, Integer divisor) {
        Double doubleDividend = (double) dividend;
        Double doubleDivisor = (double) divisor;

        Double quotient = doubleDividend / doubleDivisor;
        return quotient;
    }

    /**
     * @param dividend
     * @param divisor
     * @return Double
     * @Description:计算两个整数的 商（商保留两位小数）
     * @Date:2013-1-23 下午1:10:54
     * @since 1.0.0
     */
    public static Double calculateRoundDoubleQuotientOfTowIntegerNumber(
            Integer dividend, Integer divisor) {
        return round(calculateDoubleQuotientOfTowIntegerNumber(dividend,
                divisor));
    }

    /**
     * @param id
     * @return Number
     * @Description:返回一个有效的id值
     * @Date:2013-3-6 上午11:10:06
     * @since 1.0.0
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T toValidId(T id) {
        if (isNotAId(id)) {
            Number num = 0;
            return (T) num;
        }
        return id;
    }
}
