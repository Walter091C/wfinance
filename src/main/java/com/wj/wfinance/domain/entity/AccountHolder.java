package com.wj.wfinance.domain.entity;

import com.wj.wfinance.domain.entity.account.Account;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class AccountHolder extends User {

    private Adress address;
    private String phoneNumber;
    private String cpf;
    private String rg;
    private List<Account> accounts;

}
