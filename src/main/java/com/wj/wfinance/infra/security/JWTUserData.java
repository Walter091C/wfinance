package com.wj.wfinance.infra.security;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
