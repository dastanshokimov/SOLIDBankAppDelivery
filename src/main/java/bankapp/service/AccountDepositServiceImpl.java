package bankapp.service;

import bankapp.account.Account;
import bankapp.dao.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {

    private AccountRepository accountRepository;
    @Override
    public void deposit(double amount, Account account) {
        String accountId = String.format("%03d%06d", 1, Integer.parseInt(account.getId()+""));
        System.out.println(amount + "$ transferred to " + accountId + " account");
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }
}
