package com.bornstone.stonehenge.dao.query;


import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;

import java.util.List;

/**
 * IPaginationQuery.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 可进行分页查询的Mapper
 * @Date 2012-12-26下午4:02:24
 * @since 1.0.0
 */
public interface IPaginationQuery<T extends IEntity, Q extends PaginationQuery> extends IDAO {
    /**
     * @param query
     * @return int
     * @Description:统计查询结果数
     * @Date:2012-12-26 下午4:04:55
     * @since 1.0.0
     */
    int countByQuery(Q query);

    /**
     * @param query
     * @return List<T>
     * @Description:分页查询
     * @Date:2012-12-26 下午4:05:11
     * @since 1.0.0
     */
    List<T> selectByQuery(Q query);
}
