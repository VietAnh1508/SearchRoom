package com.searchroom.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    public void initialize(Phone phone) {
    }

    public boolean isValid(String phoneField, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneField == null)
            return false;
        return phoneField.matches("[0-9()-]*");
    }

}
