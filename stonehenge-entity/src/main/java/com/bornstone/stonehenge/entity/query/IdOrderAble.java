package com.bornstone.stonehenge.entity.query;

import com.bornstone.stonehenge.entity.entityenum.Order;

/**
 * Created by king on 16-6-4.
 */
public class IdOrderAble implements IOrderAble {
    @Override
    public String getOrderBy() {
        return "id";
    }

    @Override
    public Order getOrderValue() {
        return Order.DESC;
    }
}
