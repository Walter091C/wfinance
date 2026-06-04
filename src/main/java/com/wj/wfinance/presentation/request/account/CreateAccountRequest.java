package com.wj.wfinance.presentation.request.account;

public record CreateAccountRequest(String accountNumber, String branch, String checkDigit, String accountType) {
}
