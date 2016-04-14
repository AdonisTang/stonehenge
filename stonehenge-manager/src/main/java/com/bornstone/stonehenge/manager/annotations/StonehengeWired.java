package com.bornstone.stonehenge.manager.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by King.Tang on 14-10-24.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface StonehengeWired {
}
