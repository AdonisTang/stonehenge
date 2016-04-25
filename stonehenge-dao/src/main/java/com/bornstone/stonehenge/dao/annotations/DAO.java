package com.bornstone.stonehenge.dao.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by king on 16-4-25.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface DAO {
    String value() default "";
}
