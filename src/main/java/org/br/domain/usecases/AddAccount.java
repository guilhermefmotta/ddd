package org.br.domain.usecases;

import org.br.domain.models.Account;

import javax.enterprise.context.Dependent;

@Dependent
public interface AddAccount {
    AddAccountModel add(AddAccountModel account);
}
