package com.airfrance.testfirassahli.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AdultsOnlyValidator.class)
public @interface AdultsOnly {
    String message() default "{adultsOnly}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
