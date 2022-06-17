package bankapp.service;

import bankapp.account.Account;
import bankapp.account.AccountType;

import java.util.List;

public interface AccountListingService {

    public Account getClientAccount(String clientId, long accountId);

    public Account getClientWithdrawAccount(String clientId, Long accountId);

    public List<Account> getClientAccounts(String clientId);

    public List<Account> getClientAccountsByType(String clientId, AccountType accountType);

    public Account getClientAccountById(String s, Long accountId);
}
