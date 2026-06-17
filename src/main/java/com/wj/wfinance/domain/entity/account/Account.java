package com.wj.wfinance.domain.entity.account;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.domain.enums.AccountTypeEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public sealed class Account permits CurrentAccount, SavingsAcount {

    private Long id;
    private String accountNumber;
    private String branch;
    private String checkDigit;
    private AccountTypeEnum accountTypeEnum;
    private BigDecimal balance;
    private boolean active = true;
    private LocalDate openingDate = LocalDate.now();
    private User accountHolder;

}
