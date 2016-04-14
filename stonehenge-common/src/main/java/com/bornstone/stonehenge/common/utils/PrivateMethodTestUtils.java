package com.bornstone.stonehenge.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * PrivateMethodTestUtils.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 私有方法测试工具
 * @Date 2013-1-23下午2:40:48
 * @since 1.0.0
 */
public class PrivateMethodTestUtils {
    /**
     * @param methodHostInstance
     * @param methodName
     * @param arg
     * @return Object
     * @Description:调用只有一个参数的私有方法
     * @Date:2013-1-23 下午2:54:00
     * @since 1.0.0
     */
    public static Object invoke(Object methodHostInstance, String methodName,
                                Object arg) {
        Class<?>[] parameterTypes = {arg.getClass()};
        Object[] args = {arg};
        return invoke(methodHostInstance, methodName, parameterTypes, args);
    }

    /**
     * @param methodHostInstance
     * @param methodName
     * @param parameterTypes
     * @param args
     * @return Object
     * @Description:调用有多个参数的私有方法
     * @Date:2013-1-23 下午2:54:40
     * @since 1.0.0
     */
    public static Object invoke(Object methodHostInstance, String methodName,
                                Class<?>[] parameterTypes, Object[] args) {
        try {
            Method method = methodHostInstance.getClass().getDeclaredMethod(
                    methodName, parameterTypes);
            method.setAccessible(true);
            try {
                Object result = method.invoke(methodHostInstance, args);
                return result;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                method.setAccessible(false);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
