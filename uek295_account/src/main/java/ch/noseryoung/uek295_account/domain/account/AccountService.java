package ch.noseryoung.uek295_account.domain.account;

import java.util.List;
import java.util.UUID;

public class AccountService {
    Account createAccount(Account account);
    Account getAccount(Account account);
    List<Account> getAllAccounts();
    Account updateAccount(UUID id, Account accountDetails);
    void deleteAccount(UUID id);

}
