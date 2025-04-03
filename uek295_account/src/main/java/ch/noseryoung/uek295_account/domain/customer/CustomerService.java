package ch.noseryoung.uek295_account.domain.customer;

import ch.noseryoung.uek295_account.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepo;

    public Customer createCustomer(Customer customer) {
        if (customer.getAccounts() == null || customer.getAccounts().isEmpty()) {
            throw new InvalidEntityException("Account required");
        }
        return customerRepo.save(customer);
    }
}