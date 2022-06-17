package bankapp.service;

import bankapp.account.Account;
import org.springframework.stereotype.Service;


public interface AccountDepositService {
    public void deposit(double amount, Account accountWithdraw);
}
