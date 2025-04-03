package ch.noseryoung.uek295_account.domain.account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Account Management")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    // ✅ Create an Account (Already exists)
    @PostMapping
    @Operation(summary = "Create an account")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        return ResponseEntity.status(201).body(accountService.createAccount(account));
    }

    // ✅ Get All Accounts (Already exists)
    @GetMapping
    @Operation(summary = "Get all accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // ✅ Get an Account by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get an account by ID")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    // ✅ Update an Account
    @PutMapping("/{id}")
    @Operation(summary = "Update an account")
    public ResponseEntity<Account> updateAccount(@PathVariable UUID id, @Valid @RequestBody Account updatedAccount) {
        return ResponseEntity.ok(accountService.updateAccount(id, updatedAccount));
    }

    // ✅ Delete an Account
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an account")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
