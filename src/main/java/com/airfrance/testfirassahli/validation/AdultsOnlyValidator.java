package com.airfrance.testfirassahli.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class AdultsOnlyValidator implements ConstraintValidator<AdultsOnly, Date> {
    private static final int ADULTS_AGE = 18;

    @Override
    public boolean isValid(Date birthDate, ConstraintValidatorContext constraintValidatorContext) {
        return birthDate != null && LocalDate.now().minusYears(ADULTS_AGE)
                .isAfter(birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
