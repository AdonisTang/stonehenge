package com.bornstone.stonehenge.entity.query;

import com.bornstone.stonehenge.entity.entityenum.Order;

import java.io.Serializable;

/**
 * Created by King.Tang on 14-6-30.
 */
public interface IOrderAble extends Serializable {
    String getOrderBy();

    Order getOrderValue();
}
