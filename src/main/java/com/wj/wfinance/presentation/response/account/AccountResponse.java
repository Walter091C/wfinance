package com.wj.wfinance.presentation.response.account;

public record AccountResponse(
        Long id,
        String accountNumber,
        String branch,
        String checkDigit,
        String accountType,
        String balance,
        boolean active,
        String openingDate) {
}
