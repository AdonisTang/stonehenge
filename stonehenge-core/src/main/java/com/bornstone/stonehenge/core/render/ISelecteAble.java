package com.bornstone.stonehenge.core.render;

import java.util.List;
import java.util.Map;

/**
 * Created by King.Tang on 14-6-1.
 */
public interface ISelecteAble<T> {
    /**
     * 可以将一个对象转换成可以渲染成select的option集合
     *
     * @param instances
     * @return
     */
    Map<String, String> toSelecteOptions(List<T> instances);
}
