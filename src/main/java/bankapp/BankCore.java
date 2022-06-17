package bankapp;

import bankapp.account.AccountType;
import bankapp.service.AccountCreationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;

    public BankCore(@Qualifier("accountCreationServiceImpl") AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }

    public void createNewAccount(AccountType accountType, String clientId) {
        if(accountType != null) {
            accountCreation.create(accountType, id, clientId, lastAccountNumber);
            incrementLastAccountNumber();
        }


    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
