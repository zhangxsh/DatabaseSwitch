package com.alexzhang.dynamic;

import java.lang.annotation.*;

/**
 * Created by alexzhang on 2017/12/16.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TargetDataSource {
    Type type() default Type.PRIMARY;
}
