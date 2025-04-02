package ch.noseryoung.uek295_account.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    // Optional: Add custom queries if needed
    // Example: findByEmail(String email);
}