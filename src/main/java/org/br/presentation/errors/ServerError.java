package org.br.presentation.errors;

public class ServerError extends Exception {
    public ServerError() {
        super("Internal server error");
    }
}

