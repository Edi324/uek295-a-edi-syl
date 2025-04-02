package ch.noseryoung.uek295_account.domain.account;

import ch.noseryoung.uek295_account.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)  // Added validation
  private String email;

  @Column(nullable = false)  // Ensure password is required
  private String password;

  private LocalDateTime createdAt;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
  private Customer customer;  // Maintains 1:1 relationship
}