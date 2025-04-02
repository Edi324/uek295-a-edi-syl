package ch.noseryoung.uek295_account.domain.customer;

import ch.noseryoung.uek295_account.domain.account.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)  // Name is required
    private String name;

    private String phone;
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false)  // Customer must have an account
    private Account account;
}