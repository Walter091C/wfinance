package com.wj.wfinance.infra.persistence.repository.account;

import com.wj.wfinance.infra.persistence.entity.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {
}
