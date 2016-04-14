package com.bornstone.stonehenge.manager.binding;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 * User: king
 * Date: 14-10-14
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class ManagerProxyBuilder {
    public Object newInstance(ManagerProxy mapperProxy, Class managerClass) {
        return Enhancer.create(managerClass, mapperProxy);
    }
}
