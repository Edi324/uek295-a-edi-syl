package ch.noseryoung.uek295_account.domain.account;

import ch.noseryoung.uek295_account.exceptions.InvalidEntityException;
import ch.noseryoung.uek295_account.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AccountService {
    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        validateAccount(account);
        account.setCreatedAt(LocalDateTime.now());

        try {
            return repository.save(account);
        } catch (DataIntegrityViolationException e) {
            log.error("Account creation failed: Email already exists");
            throw new InvalidEntityException("Email already in use");
        }
    }

    public Account getAccountById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Account with ID {} not found", id);
                    return new ResourceNotFoundException("Account", id);
                });
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account updateAccount(UUID id, Account accountDetails) {
        Account account = getAccountById(id); // Reuses the existing exception handling

        if (accountDetails.getEmail() != null) {
            account.setEmail(accountDetails.getEmail());
        }
        if (accountDetails.getPassword() != null) {
            account.setPassword(accountDetails.getPassword());
        }

        return repository.save(account);
    }

    public void deleteAccount(UUID id) {
        if (!repository.existsById(id)) {
            log.warn("Delete failed: Account {} not found", id);
            throw new ResourceNotFoundException("Account", id);
        }
        repository.deleteById(id);
    }

    private void validateAccount(Account account) {
        if (account.getEmail() == null || account.getEmail().isBlank()) {
            throw new InvalidEntityException("Email is required");
        }
        if (account.getPassword() == null || account.getPassword().isBlank()) {
            throw new InvalidEntityException("Password is required");
        }
    }
}