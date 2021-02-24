package org.br.presentation.protocols;

import javax.enterprise.context.Dependent;

@Dependent
public interface EmailValidation {
    Boolean isValid(String email);
}
