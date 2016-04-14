package com.bornstone.stonehenge.dao;

import com.bornstone.stonehenge.entity.Identity;

/**
 * Created by King.Tang on 14-9-23.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IUpdate<T extends Identity> extends IDAO {
    /**
     * @param instance
     * @return int
     * @Description:更改
     * @Date:2012-11-9 下午10:18:43
     * @since 1.0.0
     */
    int update(T instance);
}
