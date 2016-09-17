package com.bornstone.stonehenge.manager.binding;

import com.bornstone.stonehenge.dao.IDAO;
import com.bornstone.stonehenge.entity.DeleteAbleEntity;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.entity.query.PaginationQuery;
import com.bornstone.stonehenge.manager.IAddAble;
import com.bornstone.stonehenge.manager.IDeleteAble;
import com.bornstone.stonehenge.manager.IModifyAble;
import com.bornstone.stonehenge.manager.annotations.StonehengeWired;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import com.bornstone.stonehenge.manager.exception.ManagerMethodExecuteException;
import com.bornstone.stonehenge.manager.method.ManagerMethod;
import com.bornstone.stonehenge.manager.method.executor.*;
import com.bornstone.stonehenge.manager.method.executor.advice.BeforeAddExecutor;
import com.bornstone.stonehenge.manager.method.executor.advice.BeforeModifyExecutor;
import com.bornstone.stonehenge.manager.query.IIdentityQueryAble;
import com.bornstone.stonehenge.manager.query.IPagenationQueryAble;
import com.bornstone.stonehenge.manager.query.IQueryAllAble;
import com.bornstone.stonehenge.manager.query.IRPCPagenationQueryAble;
import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: king
 * Date: 14-10-14
 * Time: 下午5:19
 * To change this template use File | Settings | File Templates.
 */
public class ManagerProxy implements MethodInterceptor, Serializable {
    private static final Logger logger = Logger.getLogger(ManagerProxy.class);

    private static final long serialVersionUID = -6424540398559729838L;
    protected IDAO dao;
    protected Map<ManagerMethod, IManagerMethodExecutor> methodExecutorCache = new ConcurrentHashMap<ManagerMethod, IManagerMethodExecutor>();

    public ManagerProxy() {
    }

    public ManagerProxy(IDAO dao) {
        this.dao = dao;
    }

    @Override
    public Object intercept(Object manager, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        boolean isImplemented = !Modifier.isAbstract(method.getModifiers());
        try {
            if (isImplemented) {
                return methodProxy.invokeSuper(manager, params);
            }

            if (method.getAnnotation(StonehengeWired.class) != null) {
                if (method.getReturnType() == Void.class) {
                    String msg = "The StonehengeWired Method can not return void";
                    throw new ManagerException(msg);
                }
                return stonehengeWire(method.getReturnType());
            }

            ManagerMethod managerMethod = getManagerMethod(method.getName());
            IManagerMethodExecutor executor = getManagerMethodExecutor(managerMethod);
            switch (managerMethod) {
                case GETDAO:
                    return dao;
                case SETDAO:
                    this.dao = (IDAO) params[0];
                    return null;

                case ADD:
                    AddExecutor addExecutor = (AddExecutor) executor;
                    IEntity addEntity = (IEntity) params[0];
                    return addExecutor.execute(addEntity, (IAddAble) manager);
                case DELETE:
                    DeleteExecutor deleteExecutor = (DeleteExecutor) executor;
                    DeleteAbleEntity deleteAbleEntity = (DeleteAbleEntity) params[0];
                    return deleteExecutor.execute(deleteAbleEntity, (IDeleteAble) manager);
                case MODIFY:
                    ModifyExecutor modifyExecutor = (ModifyExecutor) executor;
                    Identity modifyEntity = (Identity) params[0];
                    return modifyExecutor.execute(modifyEntity, (IModifyAble) manager);
                case QUERYBYID:
                    IdentityQueryExecutor identityQueryExecutor = (IdentityQueryExecutor) executor;
                    Number id = (Number) params[0];
                    return identityQueryExecutor.execute(id, (IIdentityQueryAble) manager);
                case PAGENATIONQUERY:
                    PagenationQueryExecutor pagenationQueryExecutor = (PagenationQueryExecutor) executor;
                    PaginationQuery paginationQuery = (PaginationQuery) params[0];
                    return pagenationQueryExecutor.execute(paginationQuery, (IPagenationQueryAble) manager);
                case RPC_PAGENATIONQUERY:
                    RPCPagenationQueryExecutor rpcPagenationQueryExecutor = (RPCPagenationQueryExecutor) executor;
                    PaginationQuery prcPaginationQuery = (PaginationQuery) params[0];
                    return rpcPagenationQueryExecutor.execute(prcPaginationQuery, (IRPCPagenationQueryAble) manager);
                case QUERYALL:
                    QueryAllExecutor queryAllExecutor = (QueryAllExecutor) executor;
                    return queryAllExecutor.execute(null, (IQueryAllAble) manager);

                case BEFOREADD:
                    BeforeAddExecutor beforeAddExecutor = (BeforeAddExecutor) executor;
                    IEntity beforeAddEntity = (IEntity) params[0];
                    return beforeAddExecutor.execute(beforeAddEntity, (IAddAble) manager);
                case BEFOREMODIFY:
                    BeforeModifyExecutor beforeModifyExecutor = (BeforeModifyExecutor) executor;
                    Identity beforeModifyEntity = (Identity) params[0];
                    return beforeModifyExecutor.execute(beforeModifyEntity, (IModifyAble) manager);

                case BEFOREADDSETDEFAULTPROPERTY:
                case BEFOREDELETE:
                case BEFOREIDENTITYQUERY:
                case BEFOREPAGENATIONQUERY:
                case BEFOREQUERYALL:
                case AFTERADD:
                case AFTERDELETE:
                case AFTERMODIFY:
                case AFTERIDENTITYQUERY:
                case AFTERPAGENATIONQUERY:
                case AFTERQUERYALL:
                    return null;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            if (e instanceof ManagerException) {
                throw e;
            } else {
                throw new ManagerException(e.getMessage());
            }
        }
        return null;
    }

    protected Object stonehengeWire(Class beanClass) throws IllegalAccessException, InstantiationException {
        return beanClass.newInstance();
    }

    private IManagerMethodExecutor getManagerMethodExecutor(ManagerMethod managerMethod) throws InstantiationException, IllegalAccessException {
        IManagerMethodExecutor executor = methodExecutorCache.get(managerMethod);
        if (executor == null) {
            executor = (IManagerMethodExecutor) managerMethod.getExecutorClass().newInstance();
            methodExecutorCache.put(managerMethod, executor);
        }
        return executor;
    }

    private ManagerMethod getManagerMethod(String methodName) {
        try {
            return ManagerMethod.find(methodName);
        } catch (IllegalArgumentException e) {
            throw new ManagerMethodExecuteException("Can not execute this method:" + methodName + ",because it's not be implemented!");
        }
    }
}
