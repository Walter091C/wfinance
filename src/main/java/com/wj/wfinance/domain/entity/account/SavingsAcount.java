package com.wj.wfinance.domain.entity.account;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class SavingsAcount extends Account {

    private double interestRate;
    private int withdrawalLimit;
    private BigDecimal minimumBalance;
    private int freeWithdrawals;
    private int withdrawalsThisMonth;
    private LocalDate lastWithdrawalDate;

}
