package com.wj.wfinance.presentation.response.account;

import java.util.List;

public record ListAccountsResponse(
        List<AccountResponse> accounts) {
}
