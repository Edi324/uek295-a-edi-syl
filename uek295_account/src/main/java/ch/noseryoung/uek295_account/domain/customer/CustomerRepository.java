package ch.noseryoung.uek295_account.domain.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Query("SELECT c FROM Customer c JOIN c.accounts a WHERE a.id = :accountId")
    Optional<Customer> findByAccounts_Id(@Param("accountId") UUID accountId);
}