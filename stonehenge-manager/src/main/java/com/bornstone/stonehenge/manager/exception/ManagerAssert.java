package com.bornstone.stonehenge.manager.exception;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;

/**
 * ManagerAssert.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description Manager断言工具类
 * @Date 2013-5-30下午3:07:18
 * @since 1.0.0
 */
public class ManagerAssert {
    private static final Logger logger = Logger.getLogger(ManagerAssert.class);

    public static void assertNotNull(Object instance) throws ManagerException {
        assertNotNull(instance, "缺少对象");
    }

    public static void assertNotNull(Object instance, String message) throws ManagerException {
        if (instance == null) {
            logger.debug("期望instance不能为空，但实际上是空的");
            throw new ManagerException(message);
        }
        if (instance instanceof Collection && ((Collection) instance).isEmpty()) {
            logger.debug("期望集合对象instance不能为空，但实际上没有任何元素");
            throw new ManagerException(message);
        }
        if (instance instanceof Map && ((Map) instance).isEmpty()) {
            logger.debug("期望集合对象instance不能为空，但实际上没有任何元素");
            throw new ManagerException(message);
        }
    }

    public static void assertNotNull(String str, String message) throws ManagerException {
        if (StringUtils.isBlank(str)) {
            logger.debug("期望字符str不能为空，但实际上是空的");
            throw new ManagerException(message);
        }
    }

    public static void assertEquals(Object expected, Object actual, String message) throws ManagerException {
        assertNotNull(expected, "期望值不能为空");
        if (!expected.equals(actual)) {
            if (logger.isDebugEnabled()) {
                if (actual == null) {
                    logger.debug("期望值为：" + expected + ",但实际值为空");
                } else {
                    logger.debug("期望值为：" + expected + ",但实际值为：" + actual);
                }
            }
            throw new ManagerException(message);
        }
    }

    public static void assertNotEquals(Object expected, Object actual, String message) throws ManagerException {
        assertNotNull(expected, "期望值不能为空");
        if (expected.equals(actual)) {
            if (logger.isDebugEnabled()) {
                if (actual == null) {
                    logger.debug("期望值不为：" + expected + ",但实际值为空");
                } else {
                    logger.debug("期望值不为：" + expected + ",但实际值为：" + actual);
                }
            }
            throw new ManagerException(message);
        }
    }

    public static void assertTrue(boolean expression, String message) throws ManagerException {
        if (!expression) {
            logger.debug("期望expression：[" + expression + "]为True,但实际值为False");
            throw new ManagerException(message);
        }
    }

    public static void assertFalse(boolean expression, String message) throws ManagerException {
        if (expression) {
            logger.debug("期望expression：[" + expression + "]为False,但实际值为True");
            throw new ManagerException(message);
        }
    }
}
