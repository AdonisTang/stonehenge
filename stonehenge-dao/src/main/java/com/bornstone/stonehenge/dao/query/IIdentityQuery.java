package com.bornstone.stonehenge.dao.query;

import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.entity.Identity;

/**
 * Created by King.Tang on 14-9-23.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IIdentityQuery<PK extends Number, T extends Identity<PK>> extends IDAO {
    /**
     * @param id
     * @return T
     * @Description:根据id查询
     * @Date:2012-11-9 下午10:18:53
     * @since 1.0.0
     */
    T selectByPrimaryKey(PK id);
}
