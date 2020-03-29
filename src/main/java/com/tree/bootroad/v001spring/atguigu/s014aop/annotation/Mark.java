package com.tree.bootroad.v001spring.atguigu.s014aop.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mark {

    String value() default "";

}
