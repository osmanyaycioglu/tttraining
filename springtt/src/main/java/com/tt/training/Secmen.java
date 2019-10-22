package com.tt.training;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RUNTIME)
@Target({ TYPE, FIELD })
@Qualifier
public @interface Secmen {
	String value() default "";
}
