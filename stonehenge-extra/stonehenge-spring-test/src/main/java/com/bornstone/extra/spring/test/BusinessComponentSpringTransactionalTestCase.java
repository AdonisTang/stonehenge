package com.bornstone.extra.spring.test;

import com.bornstone.stonehenge.common.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by king on 16-1-12.
 * 提供了一些常用的测试所需的数据
 */
public class BusinessComponentSpringTransactionalTestCase extends SpringTransactionalTestCase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static SimpleDateFormat compactDateFormat = new SimpleDateFormat("yyyyMMdd");
    protected static long currentTime = System.currentTimeMillis();
    protected static Date currentDate = new Date();
    protected static String currentDateStr = compactDateFormat.format(new Date());

    protected void log(String msg, Object... objs) {
        logger.info("===============================================");
        logger.info(msg, objs);
        logger.info("===============================================");
    }

    protected String getJsonStr(Object obj) {
        return JSONUtils.getFormatJsonStr(obj);
    }
}
