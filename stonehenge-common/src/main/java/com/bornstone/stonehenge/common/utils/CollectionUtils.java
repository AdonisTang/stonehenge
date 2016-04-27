package com.bornstone.stonehenge.common.utils;

import java.util.Collection;

/**
 * Created by king on 15-5-7.
 * 集合工具类
 */
public class CollectionUtils {
    /**
     * 获取集合的第一个元素
     *
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> T firstOrNull(Collection<T> collection) {
        return firstOrThat(collection, null);
    }

    /**
     * 获取集合的第一个元素，如果集合为空则返回指定元素
     *
     * @param collection
     * @param that
     * @param <T>
     * @return
     */
    public static <T> T firstOrThat(Collection<T> collection, T that) {
        if (collection == null || collection.size() == 0) {
            return that;
        }
        return collection.iterator().next();
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
