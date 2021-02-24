package org.br.validation;

import org.br.presentation.errors.InvalidParamError;
import org.br.presentation.helpers.HttpHelper;
import org.br.presentation.protocols.HttpResponse;


public interface IInvalidParamError {

    static <T> HttpResponse<T> error(String field) {
        return HttpHelper.badRequest(new InvalidParamError(field).getMessage());
    }
}
