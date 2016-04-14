package com.bornstone.stonehenge.common.utils;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author woodbird
 * @since 2012-11-10
 */
public class DateUtil {

    /**
     * YMD：格式为yyyy-MM-dd
     */
    public static final String YMD = "yyyy-MM-dd";
    /**
     * YMDHMS:格式为yyyy-MM-dd hh:mm:ss
     */
    public static final String YMDHMS = "yyyy-MM-dd hh:mm:ss";
    /**
     * YMDCN:为YMD中文格式
     */
    public static final String YMDCN = "yyyy年MM月dd号";

    private static final Logger logger = Logger.getLogger(DateUtil.class);

    /**
     * @param date          时间
     * @param dateformatter 时间格式:YMDHMS,YMD,YMDCN
     * @return 返回格式化后的时间若时间为空则为当前时间
     */
    public static String format(Date date, String dateformatter) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateformatter);
        String formatDate = formatter.format(date);
        return formatDate;
    }

    /**
     * 根据字符串转换为相应格式
     *
     * @param date            时间格式:YMDHMS,YMD,YMDCN
     * @param beforeformatter 传入时时间格式:YMDHMS,YMD,YMDCN
     * @param afterformatter  处理后的时间格式:YMDHMS,YMD,YMDCN
     * @return 返回格式化后的时间若时间为空则为当前时间
     */
    public String format(String date, String beforeformatter,
                         String afterformatter) {
        SimpleDateFormat beformatter = new SimpleDateFormat(beforeformatter);
        SimpleDateFormat afformatter = new SimpleDateFormat(afterformatter);
        Date formatDate;
        formatDate = null;

        try {
            formatDate = beformatter.parse(date);
            afformatter.format(formatDate);
        } catch (ParseException e) {
            logger.info("时间字符为空或者出现其他问题");

        } finally {
            if ("".equals(date) || date == null) {
                formatDate = new Date();
            }
        }
        return afformatter.format(formatDate);
    }

    /**
     * 由字符串转换为日期类型
     *
     * @param sdate         日期字符
     * @param dateformatter 日期格式
     * @return 由字符串转换为日期类型
     */
    public static Date parseDate(String sdate, String dateformatter) {
        if ("".equals(sdate) || sdate == null) {
            throw new NullPointerException("时间参数为空");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateformatter);
        Date date = null;
        try {
            date = formatter.parse(sdate);
        } catch (ParseException e) {
            logger.info(e.getMessage());
        }
        return date;
    }

    /**
     * 日期差
     *
     * @param time1 日期1
     * @param time2 日期2
     * @return 返回的是两个日期相差的天数
     */
    public static Integer datediff(Date time1, Date time2) {
        Long diff = time1.getTime() - time2.getTime();
        Long days = diff / (1000 * 60 * 60 * 24);
        return days.intValue();
    }

    /**
     * @return DateTime
     * @Description:返回今天的0:00:00
     * @Date:2013-3-4 下午5:00:32
     * @since 1.0.0
     */
    public static DateTime getTodayClock0() {
        DateTime now = DateTime.now();
        DateTime clock0 = new DateTime(now.getYear(), now.getMonthOfYear(),
                now.getDayOfMonth(), 0, 0);
        return clock0;
    }

    /**
     * @return Date
     * @Description:返回今天的0:00:00
     * @Date:2013-3-11 下午12:25:06
     * @since 1.0.0
     */
    public static Date getTimeOfTodayClock0() {
        DateTime now = getTodayClock0();
        return now.toDate();
    }
}
