package org.br.data.usecases.addAccount;

import org.br.data.protocols.AddAccountRepository;
import org.br.data.protocols.Encrypter;
import org.br.domain.usecases.AddAccount;
import org.br.domain.usecases.AddAccountModel;

public class DbAddAccount implements AddAccount {

    private final Encrypter encrypter;
    private final AddAccountRepository addAccountRepository;

    public DbAddAccount(Encrypter encrypter, AddAccountRepository addAccountRepository) {
        this.encrypter = encrypter;
        this.addAccountRepository = addAccountRepository;
    }

    @Override
    public AddAccountModel add(AddAccountModel account) {
        String hashedPassword = this.encrypter.encrypt(account.getPassword());
        account.setPassword(hashedPassword);
        this.addAccountRepository.add(account);
        return account;
    }
}
