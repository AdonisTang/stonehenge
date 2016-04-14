package com.bornstone.stonehenge.manager.method.executor;

import com.bornstone.stonehenge.dao.IUpdate;
import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.IModifyAble;
import com.bornstone.stonehenge.manager.exception.ManagerMethodExecuteException;
import org.apache.log4j.Logger;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public abstract class BaseModifyExecutor {
    private static final Logger logger = Logger.getLogger(BaseModifyExecutor.class);

    public <T extends Identity> T executeModify(T instance, IModifyAble<T> manager) {
        try {
            executeBefore(instance, manager);
            IUpdate<T> dao = manager.getDAO();
            int result = dao.update(instance);
            if (result > 0) {
                executeAfter(instance, manager);
                return instance;
            } else {
                throw new ManagerMethodExecuteException("0条记录被修改");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ManagerMethodExecuteException("修改失败");
        }
    }

    protected abstract <T extends Identity> void executeBefore(T instance, IModifyAble<T> manager);

    protected abstract <T extends Identity> void executeAfter(T instance, IModifyAble<T> manager);
}
