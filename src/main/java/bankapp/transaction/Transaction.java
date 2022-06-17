package bankapp.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long id;
    private String type; // transaction type either DEPOSIT or WITHDRAW
    private String date;
    private String clientId;
    private Long accountId;
    private double amount;

    public Transaction() {

    }



    public Transaction(String type, String date, String clientId, Long accountId, double amount) {
        this.type = type;
        this.date = date;
        this.clientId = clientId;
        this.accountId = accountId;
        this.amount = amount;
    }
}
