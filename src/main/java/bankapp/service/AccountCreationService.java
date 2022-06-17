package bankapp.service;

import bankapp.account.AccountType;
import org.springframework.stereotype.Service;


public interface AccountCreationService {

    public void create(AccountType accountType, long bankId, String clientId, long accountId);

}
