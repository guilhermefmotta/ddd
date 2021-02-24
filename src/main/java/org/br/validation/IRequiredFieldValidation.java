package org.br.validation;

import org.br.presentation.data.Signup;
import org.br.presentation.errors.MissingParamError;
import org.br.presentation.helpers.HttpHelper;
import org.br.presentation.protocols.HttpRequest;
import org.br.presentation.protocols.HttpResponse;

import java.lang.reflect.Field;

public interface IRequiredFieldValidation {

    static <T> HttpResponse <T> error(HttpRequest<T> httpRequest) throws NoSuchFieldException, IllegalAccessException {
        for (String requiredField : Signup.requiredFields()) {
            Field field = httpRequest.get().getClass().getDeclaredField(requiredField);
            field.setAccessible(true);
            Object value = field.get(httpRequest.get());
            if (value == null) {
                return HttpHelper.badRequest(new MissingParamError(field.getName()).getMessage());
            }
        }
        return null;
    }

}
