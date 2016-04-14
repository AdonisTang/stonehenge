package com.bornstone.stonehenge.common.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;

import java.sql.Timestamp;

/**
 * BeanUtils.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 描述一下这个文件
 * @Date 2013-3-4下午2:39:50
 * @since 1.0.0
 */
public class BeanUtils {
    /**
     * @return BeanUtilsBean
     * @Description:BeanUtilsBean 初始化
     * @Date:2013-3-4 下午2:40:27
     * @since 1.0.0
     */
    public static BeanUtilsBean createBeanUtils() {
        ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();

        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern("yyyy-MM-dd");

        convertUtilsBean.register(dateConverter, java.util.Date.class);
        convertUtilsBean.register(dateConverter, Timestamp.class);
        convertUtilsBean.register(dateConverter, java.sql.Date.class);

        return new BeanUtilsBean(convertUtilsBean);
    }
}
