package com.wj.wfinance.presentation.controller.account;

import com.wj.wfinance.presentation.request.account.CreateAccountRequest;
import com.wj.wfinance.presentation.response.account.AccountResponse;
import com.wj.wfinance.presentation.response.account.ListAccountsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Account", description = "Operações relacionadas a contas bancárias, incluindo criação, consulta, atualização e exclusão de contas.")
public class AccountController {

    @PostMapping("/create")
    @Operation(
            summary = "Create a new account",
            description = "Creates a new bank account with the provided details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account created successfully",
                    content = @Content(schema = @Schema(implementation = AccountResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<AccountResponse> createAccount(CreateAccountRequest request) {
        return ResponseEntity.ok(new AccountResponse(null, request.accountNumber(), request.branch(), request.checkDigit(), request.accountType(), null, true, null));
    }

    @GetMapping("/list")
    @Operation(
            summary = "List all accounts for the authenticated user",
            description = "Retrieves a list of all bank accounts associated with the authenticated user."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Accounts retrieved successfully",
                    content = @Content(schema = @Schema(implementation = ListAccountsResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<ListAccountsResponse> listAccounts() {
        return ResponseEntity.ok(new ListAccountsResponse(List.of()));
    }

    @GetMapping("/get/{id}")
    @Operation(
            summary = "Get account details by ID",
            description = "Retrieves the details of a specific bank account using its unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account details retrieved successfully",
                    content = @Content(schema = @Schema(implementation = AccountResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<AccountResponse> getAccountById(String id) {
        return ResponseEntity.ok(new AccountResponse(null, null, null, null, null, null, true, null));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete account by ID",
            description = "Deletes a specific bank account using its unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid Data Provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public ResponseEntity<Void> deleteAccount(String id) {
        return ResponseEntity.ok().build();
    }

}
