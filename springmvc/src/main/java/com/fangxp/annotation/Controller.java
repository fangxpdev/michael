package com.fangxp.annotation;

import java.lang.annotation.*;

/**
 * Created by michael on 2017/3/8.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Controller {

    String value() default "";

}
