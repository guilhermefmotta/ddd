package org.br.presentation.errors;

public class MissingParamError extends Exception {
    public MissingParamError(String field) {
        super("Missing param:" + field);
    }
}
