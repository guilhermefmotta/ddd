package org.br.presentation.controller;

import org.br.domain.models.Account;
import org.br.domain.usecases.AddAccount;
import org.br.domain.usecases.AddAccountModel;
import org.br.presentation.data.Signup;
import org.br.presentation.errors.InvalidParamError;
import org.br.presentation.errors.MissingParamError;
import org.br.presentation.errors.ServerError;
import org.br.presentation.helpers.HttpHelper;
import org.br.presentation.protocols.Controller;
import org.br.presentation.protocols.EmailValidation;
import org.br.presentation.protocols.HttpRequest;
import org.br.presentation.protocols.HttpResponse;
import org.br.validation.IInvalidParamError;
import org.br.validation.IRequiredFieldValidation;

import javax.ws.rs.Path;
import java.util.Objects;

@Path("/signup")
public class SignupController implements Controller<Account,Signup> {

    private final EmailValidation emailValidation;
    private final AddAccount addAccount;

    public SignupController(EmailValidation emailValidation, AddAccount addAccount) {
        this.emailValidation = emailValidation;
        this.addAccount = addAccount;
    }

    @Override
    public HttpResponse<Account> handle(HttpRequest<Signup> httpRequest) throws NoSuchFieldException, IllegalAccessException {
        try {
            IRequiredFieldValidation.error(httpRequest);
            Boolean isValid = this.emailValidation.isValid(httpRequest.get().getEmail());
            if (!isValid) return HttpHelper.badRequest(new InvalidParamError("email").getMessage());
            if (!Objects.equals(httpRequest.get().getPassword(), httpRequest.get().getPasswordConfirmation())) return IInvalidParamError.error("Passwords must be equals");
            return HttpHelper.ok(this.addAccount.add(new AddAccountModel(httpRequest.get().getName(), httpRequest.get().getEmail(),httpRequest.get().getPassword())));
        } catch (InternalError e) {
            return HttpHelper.serverError();
        }
    }
}