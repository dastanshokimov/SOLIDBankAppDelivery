package bankapp.service;

import bankapp.account.Account;
import bankapp.account.AccountType;
import bankapp.exception.AccountNotFoundException;
import bankapp.dao.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class AccountListingServiceImpl implements AccountListingService {
    private AccountRepository accountRepository;


    @Override
    public Account getClientAccount(String clientId, long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if(account.isPresent())
            return account.get();
        throw new AccountNotFoundException(accountId);
    }

    @Override
    public Account getClientWithdrawAccount(String clientId, Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getClientAccountsByType(String clientId, AccountType accountType) {
        return null;//accountRepository.findAccountsByType(clientId, accountType.getType());
    }

    @Override
    public Account getClientAccountById(String clientId, Long accountId) {
        Account account = accountRepository.findAccountById(accountId);
        if(account == null) {
            throw new AccountNotFoundException(accountId);
        }
        return account;
    }
}
