package bankapp.service;

import bankapp.account.Account;
import bankapp.account.AccountType;
import bankapp.dao.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCreationServiceWebImpl implements AccountCreationServiceWeb {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Long createAccount(Account account) {
        boolean isWithdrawAllowed = true;
        if(account.getAccountType().equals("FIXED"))
           isWithdrawAllowed = false;
        account.setWithdrawAllowed(isWithdrawAllowed);
        accountRepository.save(account);
        return account.getId();
    }
}
