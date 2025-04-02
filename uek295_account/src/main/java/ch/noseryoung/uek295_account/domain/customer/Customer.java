package ch.noseryoung.uek295_account.domain.customer;

import ch.noseryoung.uek295_account.domain.account.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String phone;

    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    @NotNull(message = "Account cannot be null")
    private Account account;
}