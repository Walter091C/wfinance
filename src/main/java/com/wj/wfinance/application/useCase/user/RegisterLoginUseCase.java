package com.wj.wfinance.application.useCase.user;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.domain.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

public class RegisterLoginUseCase {

    @Value("${rabbitmq.queuename")
    private String queueName;

    private final UserRepository userRepository;
    private final RabbitTemplate rabbitTemplate;

    public RegisterLoginUseCase(UserRepository userRepository, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void register(User user) {
        userRepository.save(user);
        rabbitTemplate.convertAndSend("user.registered", queueName);
    }
}
