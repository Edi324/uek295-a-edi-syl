package ch.noseryoung.uek295_account.domain.account;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(UUID id) {
        return accountRepository.findById(id).orElseThrow();
    }

    // Implement other methods (getAll, update, delete) similarly...
}