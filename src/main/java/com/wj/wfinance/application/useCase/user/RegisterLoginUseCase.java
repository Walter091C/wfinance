package com.wj.wfinance.application.useCase.user;

import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.domain.repository.UserRepository;

public class RegisterLoginUseCase {

    private final UserRepository userRepository;

    public RegisterLoginUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
