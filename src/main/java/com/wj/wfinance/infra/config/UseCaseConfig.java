package com.wj.wfinance.infra.config;

import com.wj.wfinance.application.useCase.user.RegisterLoginUseCase;
import com.wj.wfinance.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterLoginUseCase registerLoginUseCase(UserRepository userRepository) {
        return new RegisterLoginUseCase(userRepository);
    }
}
