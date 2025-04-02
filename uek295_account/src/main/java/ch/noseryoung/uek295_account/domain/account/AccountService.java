package ch.noseryoung.uek295_account.domain.account;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Log4j2
@Service
public class AccountService {
    private final AccountRepository repository;

    @Autowired  // Constructor injection (more idiomatic than field injection)
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(Account account) {
        account.setCreatedAt(LocalDateTime.now());
        return repository.save(account);
    }

    public Account getAccountById(UUID id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("Account with ID {} not found", id);
            return new NoSuchElementException("Account not found");
        });
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account updateAccount(UUID id, Account accountDetails) {
        Account account = repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Account not found"));

        // Partial update (only non-null fields)
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
            throw new NoSuchElementException("Account not found");
        }
        repository.deleteById(id);
    }
}