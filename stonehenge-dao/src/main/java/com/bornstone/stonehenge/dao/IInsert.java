package com.bornstone.stonehenge.dao;

import com.bornstone.stonehenge.entity.IEntity;

/**
 * Created by King.Tang on 14-9-23.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IInsert<T extends IEntity> extends IDAO {
    /**
     * @param instance
     * @return int
     * @Description:添加
     * @Date:2012-11-9 下午10:18:34
     * @since 1.0.0
     */
    int insert(T instance);
}
