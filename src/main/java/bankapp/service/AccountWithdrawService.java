package bankapp.service;

import bankapp.account.Account;
import bankapp.account.AccountWithdraw;
import org.springframework.stereotype.Service;


public interface AccountWithdrawService {
    public void withdraw(double amount, Account account);
}
