package com.bornstone.stonehenge.entity.query;

import com.bornstone.stonehenge.entity.entityenum.Order;

/**
 * Created by King.Tang on 14-6-30.
 */
public interface IOrderAble {
    String getOrderBy();

    Order getOrderValue();
}
