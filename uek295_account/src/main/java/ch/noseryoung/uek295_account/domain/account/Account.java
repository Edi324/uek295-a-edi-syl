package ch.noseryoung.uek295_account.domain.account;

import ch.noseryoung.uek295_account.domain.customer.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "accounts")  // Explicit table name
@Getter
@Setter
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "account_id")
  private UUID id;

  @Column(nullable = false, unique = true)
  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Invalid email format")
  private String email;

  @Column(nullable = false)
  @NotBlank(message = "Password cannot be blank")
  private String password;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private LocalDateTime createdAt;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
  private Customer customer;
}