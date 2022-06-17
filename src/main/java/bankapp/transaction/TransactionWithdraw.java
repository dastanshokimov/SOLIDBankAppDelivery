package bankapp.transaction;

import bankapp.account.Account;
import bankapp.dao.TransactionRepository;
import bankapp.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionRepository transactionRepository;

    public void execute(double amount, Account accountWithdraw) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Long accountId = accountWithdraw.getId();
        String clientId = accountWithdraw.getClientId();
        String now = new Date().toString();
        Transaction transaction = new Transaction("WITHDRAW", now, clientId, accountId, amount);
        transactionRepository.save(transaction);
    }
}
