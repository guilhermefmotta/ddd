package org.br.presentation.protocols;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class HttpResponse<T> {
    private Integer statusCode;
    private T body;
    private String bodyString;

    public HttpResponse() {
        this.body = null;
    }

    public HttpResponse(Integer statusCode,T body) {
        this.body = Objects.requireNonNull(body);
        this.statusCode = statusCode;
    }

    public HttpResponse(T body) {
        this.body = Objects.requireNonNull(body);
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public void setBodyString(String bodyString) {
        this.bodyString = bodyString;
    }

    public HttpResponse(Integer statusCode, String bodyString) {
        this.statusCode = Objects.requireNonNull(statusCode);
        this.bodyString = Objects.requireNonNull(bodyString);
    }

    public T get() {
        if (body == null) {
            throw new NoSuchElementException("No value present");
        }
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpResponse<?> that = (HttpResponse<?>) o;
        return Objects.equals(statusCode, that.statusCode) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, body);
    }
}
