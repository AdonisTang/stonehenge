package com.bornstone.stonehenge.dao.annotations;

import java.lang.annotation.*;

/**
 * Created by king on 16-4-25.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DAO {
    String value() default "";
}
