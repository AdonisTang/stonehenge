package com.bornstone.stonehenge.entity;

/**
 * Created by King.Tang on 14-9-23.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface Identity<PK extends Number> extends IEntity {
    /**
     * id getter
     *
     * @return
     */
    PK getId();

    /**
     * id setter
     *
     * @param id
     */
    void setId(PK id);
}
