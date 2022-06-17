package bankapp.account;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private Long id;
    private String accountType;
    private String clientId;
    private double balance;
    private boolean withdrawAllowed;

    public Account(String accountType, String clientId, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.clientId = clientId;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    public Account() {

    }

    @Override
    public String toString() {
        String accountNumber = String.format("%03d%06d", 1, Integer.parseInt(this.id+""));

        return "Account{" +
                "account_id=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", clientId='" + clientId + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
}
