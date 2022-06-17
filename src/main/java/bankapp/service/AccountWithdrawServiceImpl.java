package bankapp.service;

import bankapp.account.Account;
import bankapp.account.AccountWithdraw;
import bankapp.dao.AccountRepository;
import bankapp.exception.WithdrawException;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void withdraw(double amount, Account account) {
        double withdrawResult = account.getBalance()-amount;
        if(account.isWithdrawAllowed()) {
            if(withdrawResult >= 0) {
                String accountId  = String.format("%03d%06d", 1, Integer.parseInt(account.getId()+""));
                System.out.println(amount + "$ transferred from " + accountId + " account");
                account.setBalance(withdrawResult);
                accountRepository.save(account);
            } else {
                throw new WithdrawException("Withdraw not possible: not enough money");
            }
        } else {
            throw new WithdrawException("WITHDRAW NOT ALLOWED on FIXED ACCOUNT");
        }
    }
}
