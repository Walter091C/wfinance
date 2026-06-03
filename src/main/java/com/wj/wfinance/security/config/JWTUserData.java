package com.wj.wfinance.security.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
