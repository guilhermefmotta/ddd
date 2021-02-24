package org.br.utils;

import org.apache.commons.validator.routines.EmailValidator;
import org.br.presentation.protocols.EmailValidation;

public class EmailValidatorAdapter implements EmailValidation {

    @Override
    public Boolean isValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
