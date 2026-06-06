package com.wj.wfinance.application.useCase.account;

import com.wj.wfinance.domain.entity.account.Account;
import com.wj.wfinance.domain.repository.account.AccountRepository;

public class CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.createAccount(account);
    }
}
