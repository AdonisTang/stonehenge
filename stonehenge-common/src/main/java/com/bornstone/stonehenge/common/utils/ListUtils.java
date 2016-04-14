package com.bornstone.stonehenge.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ListUtils.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description List工具类
 * @Date 2013-3-5下午9:15:19
 * @since 1.0.0
 */
public class ListUtils {
    /**
     * @param list
     * @return List<T>
     * @Description:如果list为null 或 没有元素 则返回一个空的list
     * @Date:2013-3-5 下午9:24:17
     * @since 1.0.0
     */
    public static <T> List<T> newListWhenNull(List<T> list) {
        if (isEmpty(list)) {
            list = new ArrayList<T>();
        }
        return list;
    }

    /**
     * @param list
     * @return boolean
     * @Description:为null或没有元素
     * @Date:2013-3-5 下午9:22:11
     * @since 1.0.0
     */
    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() == 0;
    }

    /**
     * @param list
     * @return boolean
     * @Description:不为null 且 包含元素
     * @Date:2013-3-5 下午9:23:06
     * @since 1.0.0
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        return !isEmpty(list);
    }
}
