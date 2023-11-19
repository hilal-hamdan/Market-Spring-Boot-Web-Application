package com.example.market.annotation;

import com.example.market.validations.UserExistsValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = UserExistsValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistedUser {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Email already used..!";



}