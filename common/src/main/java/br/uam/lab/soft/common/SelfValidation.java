package br.uam.lab.soft.common;

import javax.validation.*;
import java.util.Set;

public abstract class SelfValidation<T> {

    private Validator validator;

    public SelfValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
