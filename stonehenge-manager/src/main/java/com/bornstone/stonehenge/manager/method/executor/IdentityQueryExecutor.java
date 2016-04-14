package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.query.IIdentityQuery;
import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.advice.IAfterIdentityQuery;
import com.bornstone.stonehenge.manager.advice.IBeforeIdentityQuery;
import com.bornstone.stonehenge.manager.exception.ManagerMethodExecuteException;
import com.bornstone.stonehenge.manager.query.IIdentityQueryAble;
import org.apache.log4j.Logger;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-10-13.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class IdentityQueryExecutor<PK extends Number, T extends Identity<PK>> implements IManagerMethodExecutor<PK, T, IIdentityQueryAble<PK, T>> {
    private static final Logger logger = Logger.getLogger(IdentityQueryExecutor.class);

    @Override
    public T execute(PK id, IIdentityQueryAble<PK, T> manager) {
        try {
            if (manager instanceof IBeforeIdentityQuery) {
                ((IBeforeIdentityQuery) manager).beforeIdentityQuery(id);
            }

            IIdentityQuery<PK, T> dao = manager.getDAO();
            T instance = dao.selectByPrimaryKey(id);
            assertNotNull(instance, "该记录不存在");

            if (manager instanceof IAfterIdentityQuery) {
                ((IAfterIdentityQuery) manager).afterIdentityQuery(instance);
            }

            return instance;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ManagerMethodExecuteException(e);
        }
    }
}
