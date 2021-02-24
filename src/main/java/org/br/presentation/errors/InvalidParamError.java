package org.br.presentation.errors;

public class InvalidParamError extends Exception {
    public InvalidParamError(String field) {
        super("Invalid param:" + field);
    }
}
