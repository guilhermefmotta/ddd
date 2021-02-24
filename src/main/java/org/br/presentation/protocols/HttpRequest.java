package org.br.presentation.protocols;


import java.util.NoSuchElementException;
import java.util.Objects;

public final class HttpRequest<T> {
    private T body;
    private String bodyString;

    private HttpRequest() {
        this.body = null;
        this.bodyString = null;
    }

    public HttpRequest(T body) {
        this.body = Objects.requireNonNull(body);
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
        HttpRequest<?> that = (HttpRequest<?>) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }
}
