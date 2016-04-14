package com.bornstone.stonehenge.spring.manager;

import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.manager.binding.ManagerProxy;
import org.springframework.context.ApplicationContext;

/**
 * Created by King.Tang on 14-10-24.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class ManagerProxyBean extends ManagerProxy {
    private ApplicationContext applicationContext;

    public ManagerProxyBean() {
    }

    public ManagerProxyBean(IDAO dao, ApplicationContext applicationContext) {
        super(dao);
        this.applicationContext = applicationContext;
    }

    protected Object stonehengeWire(Class beanClass) throws IllegalAccessException, InstantiationException {
        return applicationContext.getBean(beanClass);
    }
}
