package com.becky.demo.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface PublicAPIController {
    String message() default "";
    String messageKey() default "";
}
