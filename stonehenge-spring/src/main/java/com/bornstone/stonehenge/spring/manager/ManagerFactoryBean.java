package com.bornstone.stonehenge.spring.manager;

import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.manager.IManager;
import com.bornstone.stonehenge.manager.binding.ManagerProxyBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: king
 * Date: 14-10-14
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class ManagerFactoryBean<T extends IManager> implements FactoryBean<T> {
    private Class<T> manager;
    private IDAO dao;
    private ApplicationContext applicationContext;

    public T getObject() throws Exception {
        ManagerProxyBuilder builder = new ManagerProxyBuilder();
        T managerProxyBean = (T) builder.newInstance(new ManagerProxyBean(dao, applicationContext), manager);
        return managerProxyBean;
    }

    @Override
    public Class<?> getObjectType() {
        return this.manager;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setManager(Class<T> manager) {
        this.manager = manager;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
