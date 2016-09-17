package com.bornstone.stonehenge.manager.method;

import com.bornstone.stonehenge.manager.method.executor.*;
import com.bornstone.stonehenge.manager.method.executor.advice.BeforeAddExecutor;
import com.bornstone.stonehenge.manager.method.executor.advice.BeforeModifyExecutor;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by King.Tang on 14-10-18.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public enum ManagerMethod {
    GETDAO("getDAO", DoNothingExecutor.class),
    SETDAO("setDAO", DoNothingExecutor.class),

    ADD("add", AddExecutor.class),
    DELETE("delete", DeleteExecutor.class),
    MODIFY("modify", ModifyExecutor.class),
    QUERYBYID("queryById", IdentityQueryExecutor.class),
    PAGENATIONQUERY("query", PagenationQueryExecutor.class),
    RPC_PAGENATIONQUERY("rpcQuery", RPCPagenationQueryExecutor.class),
    QUERYALL("queryAll", QueryAllExecutor.class),

    BEFOREADD("beforeAdd", BeforeAddExecutor.class),
    BEFOREADDSETDEFAULTPROPERTY("beforeAddSetDefaultProperty", DoNothingExecutor.class),
    BEFOREDELETE("beforeDelete", DoNothingExecutor.class),
    BEFOREMODIFY("beforeModify", BeforeModifyExecutor.class),
    BEFOREIDENTITYQUERY("beforeIdentityQuery", DoNothingExecutor.class),
    BEFOREPAGENATIONQUERY("beforePagenationQuery", DoNothingExecutor.class),
    BEFOREQUERYALL("beforeQueryAll", DoNothingExecutor.class),

    AFTERADD("afterAdd", DoNothingExecutor.class),
    AFTERDELETE("afterDelete", DoNothingExecutor.class),
    AFTERMODIFY("afterModify", DoNothingExecutor.class),
    AFTERIDENTITYQUERY("afterIdentityQuery", DoNothingExecutor.class),
    AFTERPAGENATIONQUERY("afterPagenationQuery", DoNothingExecutor.class),
    AFTERQUERYALL("afterQueryAll", DoNothingExecutor.class),;

    private String methodName;
    private Class executorClass;

    private ManagerMethod(String methodName, Class executorClass) {
        this.methodName = methodName;
        this.executorClass = executorClass;
    }

    public static ManagerMethod find(String methodName) {
        if (StringUtils.isBlank(methodName)) {
            throw new IllegalArgumentException("ManagerMethod name can not be null");
        }
        for (ManagerMethod managerMethod : ManagerMethod.values()) {
            if (methodName.equalsIgnoreCase(managerMethod.getMethodName())) {
                return managerMethod;
            }
        }
        throw new IllegalArgumentException("The ManagerMethod name of [" + methodName + "] is not found!");
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class getExecutorClass() {
        return executorClass;
    }

    public void setExecutorClass(Class executorClass) {
        this.executorClass = executorClass;
    }
}
