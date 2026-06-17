package com.wj.wfinance.infra.config;

import com.wj.wfinance.application.useCase.user.RegisterLoginUseCase;
import com.wj.wfinance.domain.repository.user.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterLoginUseCase registerLoginUseCase(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        return new RegisterLoginUseCase(userRepository, rabbitTemplate);
    }
}
