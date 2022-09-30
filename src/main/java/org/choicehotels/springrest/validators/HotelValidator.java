package org.choicehotels.springrest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HotelValidator implements
        ConstraintValidator<FieldsValueMatch, String> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }


}
