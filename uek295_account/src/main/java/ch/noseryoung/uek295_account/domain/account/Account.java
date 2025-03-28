package ch.noseryoung.uek295_account.domain.account;

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

  private String email;
  private String password;
  private LocalDateTime createdAt;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;


}
