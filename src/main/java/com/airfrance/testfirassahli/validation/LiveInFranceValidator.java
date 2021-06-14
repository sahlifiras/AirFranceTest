package com.airfrance.testfirassahli.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LiveInFranceValidator implements ConstraintValidator<LiveInFrance, String> {
    private static final String FRANCE = "france";

    @Override
    public boolean isValid(String address, ConstraintValidatorContext constraintValidatorContext) {
        return address.toLowerCase().contains(FRANCE);
    }
}
