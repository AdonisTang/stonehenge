package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.IInsert;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.manager.IAddAble;
import com.bornstone.stonehenge.manager.advice.IAfterAdd;
import com.bornstone.stonehenge.manager.advice.IBeforeAdd;
import com.bornstone.stonehenge.manager.advice.IBeforeAddSetDefaultProperty;
import com.bornstone.stonehenge.manager.exception.ManagerMethodExecuteException;
import org.apache.log4j.Logger;

import static com.bornstone.stonehenge.manager.exception.ManagerAssert.assertNotNull;

/**
 * Created by King.Tang on 14-10-13.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class AddExecutor<T extends IEntity> implements IManagerMethodExecutor<T, T, IAddAble<T>> {
    private static final Logger logger = Logger.getLogger(AddExecutor.class);

    @Override
    public T execute(T instance, IAddAble<T> manager) {
        try {
            assertNotNull(instance, "添加的对象不能为空");

            if (manager instanceof IBeforeAdd) {
                ((IBeforeAdd) manager).beforeAdd(instance);
            }

            if (manager instanceof IBeforeAddSetDefaultProperty) {
                ((IBeforeAddSetDefaultProperty) manager).beforeAddSetDefaultProperty(instance);
            }

            IInsert<T> dao = manager.getDAO();
            int result = dao.insert(instance);
            if (result > 0) {
                if (manager instanceof IAfterAdd) {
                    ((IAfterAdd) manager).afterAdd(instance);
                }
                return instance;
            } else {
                throw new ManagerMethodExecuteException("0条记录被添加");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ManagerMethodExecuteException(e.getMessage());
        }
    }
}
