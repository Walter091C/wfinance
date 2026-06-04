package com.wj.wfinance.presentation.controller.user;

import com.wj.wfinance.application.useCase.user.RegisterLoginUseCase;
import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.infra.persistence.entity.UserEntity;
import com.wj.wfinance.infra.security.config.TokenConfig;
import com.wj.wfinance.presentation.request.user.LoginRequest;
import com.wj.wfinance.presentation.request.user.RegisterUserRequest;
import com.wj.wfinance.presentation.response.user.LoginResponse;
import com.wj.wfinance.presentation.response.user.RegisterUserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterLoginUseCase registerLoginUseCase;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public UserController(RegisterLoginUseCase registerLoginUseCase, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.registerLoginUseCase = registerLoginUseCase;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken usernamePass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(usernamePass);

        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        String token = tokenConfig.generateToken(userEntity);

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        User newUser = new User(null, request.name(), request.email(), passwordEncoder.encode(request.password()));

        registerLoginUseCase.register(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
