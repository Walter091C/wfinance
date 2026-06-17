package com.wj.wfinance.presentation.controller.user;

import com.wj.wfinance.application.useCase.user.RegisterLoginUseCase;
import com.wj.wfinance.domain.entity.User;
import com.wj.wfinance.infra.persistence.entity.user.UserEntity;
import com.wj.wfinance.infra.security.config.TokenConfig;
import com.wj.wfinance.presentation.request.user.LoginRequest;
import com.wj.wfinance.presentation.request.user.RegisterUserRequest;
import com.wj.wfinance.presentation.response.user.LoginResponse;
import com.wj.wfinance.presentation.response.user.RegisterUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User", description = "Operações de Login e Registro de Usuário")
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
    @Operation(
            summary = "Login with user credentials",
            description = "Authenticates the user and returns a JWT token if the credentials are valid"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful",
                    content = @Content(schema = @Schema(implementation = LoginResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken usernamePass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(usernamePass);

        UserEntity userEntity = (UserEntity) authentication.getPrincipal();
        String token = tokenConfig.generateToken(userEntity);

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    @Operation(
            summary = "Register new User",
            description = "Creates a new user in the system"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = RegisterUserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        User newUser = new User(null, request.name(), request.email(), passwordEncoder.encode(request.password()));

        registerLoginUseCase.register(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getName(), newUser.getEmail()));
    }
}
