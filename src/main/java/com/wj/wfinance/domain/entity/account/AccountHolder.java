package com.wj.wfinance.domain.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class AccountHolder {

    private int userId;
    private Adress address;
    private String phoneNumber;
    private String cpf;
    private String rg;
    private List<Account> accounts;

}
