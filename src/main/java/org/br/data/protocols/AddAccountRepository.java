package org.br.data.protocols;

import org.br.domain.models.Account;
import org.br.domain.usecases.AddAccountModel;

public interface AddAccountRepository {

    Account add(AddAccountModel account);
}
