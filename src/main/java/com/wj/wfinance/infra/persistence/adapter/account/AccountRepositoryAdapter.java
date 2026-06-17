package com.wj.wfinance.infra.persistence.adapter.account;

import com.wj.wfinance.domain.entity.account.Account;
import com.wj.wfinance.domain.repository.account.AccountRepository;
import com.wj.wfinance.infra.persistence.mapper.account.AccountEntityMapper;
import com.wj.wfinance.infra.persistence.repository.account.AccountJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountJpaRepository jpaRepository;
    private final AccountEntityMapper mapper;

    public AccountRepositoryAdapter(AccountJpaRepository jpaRepository, AccountEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void createAccount(Account account) {
        jpaRepository.save(mapper.toEntity(account));
    }
}
