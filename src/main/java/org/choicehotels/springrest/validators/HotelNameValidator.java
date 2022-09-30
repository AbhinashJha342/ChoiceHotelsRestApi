package org.choicehotels.springrest.validators;

import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HotelNameValidator implements ConstraintValidator<NameValidatorConstraint, String> {


    @Override
    public void initialize(NameValidatorConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("get the details"+name);
        return ObjectUtils.isEmpty(name);
    }
}
