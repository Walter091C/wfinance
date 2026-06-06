package com.wj.wfinance.infra.persistence.mapper.account;

import com.wj.wfinance.domain.entity.account.Account;
import com.wj.wfinance.infra.persistence.entity.account.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {


    Account toDomain(AccountEntity accountEntity);

    AccountEntity toEntity(Account account);
}
