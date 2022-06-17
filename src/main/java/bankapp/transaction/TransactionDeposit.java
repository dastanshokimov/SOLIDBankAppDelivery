package bankapp.transaction;

import bankapp.account.Account;
import bankapp.dao.TransactionRepository;
import bankapp.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionRepository transactionRepository;
    public void execute(double amount, Account accountDeposit) {

        accountDepositService.deposit(amount, accountDeposit);
        Long accountId = accountDeposit.getId();
        String now = new Date().toString();
        Transaction transaction = new Transaction("DEPOSIT", now, "1", accountId, amount);
        transactionRepository.save(transaction);
    }
}
