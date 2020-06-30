package com.training.ykb.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidationCheck implements ConstraintValidator<MyValidation, String> {


    private MyValidation anno;

    @Override
    public void initialize(final MyValidation anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.anno.start());
    }

}
