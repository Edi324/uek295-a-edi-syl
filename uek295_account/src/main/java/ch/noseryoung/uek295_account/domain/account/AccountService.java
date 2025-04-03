package ch.noseryoung.uek295_account.domain.account;

import ch.noseryoung.uek295_account.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account", id));
    }

    public Account updateAccount(UUID id, Account updatedAccount) {
        Account existingAccount = getAccountById(id);
        existingAccount.setEmail(updatedAccount.getEmail());
        existingAccount.setPassword(updatedAccount.getPassword());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(UUID id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }
}
