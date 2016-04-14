package com.bornstone.stonehenge.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 字段描述 注解
 * @Date 2012-12-31下午4:45:24
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Description {
    /**
     * @return String
     * @Description:字段描述
     * @Date:2012-12-31 下午4:47:57
     * @since 1.0.0
     */
    String value() default "";
}
