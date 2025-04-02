package ch.noseryoung.uek295_account.domain.customer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.UUID;

@Log4j2
@Service
public class CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getAccount() == null) {
            log.error("Customer creation failed: No linked account");
            throw new IllegalArgumentException("Customer must have an account");
        }
        return repository.save(customer);
    }

    public Customer getCustomerByAccountId(UUID accountId) {
        return repository.findByAccountId(accountId).orElseThrow(() -> {
            log.error("Customer for Account ID {} not found", accountId);
            return new NoSuchElementException("Customer not found for this account");
        });
    }
}