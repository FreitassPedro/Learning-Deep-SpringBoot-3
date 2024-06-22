package com.pedro.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidation implements ConstraintValidator<CourseCode, String> {

    private String coursePrfix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrfix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String message, ConstraintValidatorContext constraintValidatorContext) {
        // Implemente a lógica que você desejar!
        boolean result = true;

        if(message != null) result = message.startsWith(coursePrfix);

        return result;
    }
}
