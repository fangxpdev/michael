package com.fangxp.annotation;

import java.lang.annotation.*;

/**
 * Created by michael on 2017/3/8.
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    String value() default "";

}
