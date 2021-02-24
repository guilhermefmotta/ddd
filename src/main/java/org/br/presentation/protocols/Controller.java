package org.br.presentation.protocols;

public interface Controller<T, Q> {
    HttpResponse<T> handle(HttpRequest<Q> httpRequest) throws NoSuchFieldException, IllegalAccessException;
}
