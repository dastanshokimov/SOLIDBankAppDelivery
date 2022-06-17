package bankapp.cli;

import bankapp.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface CreateAccountOperationUI {
    public AccountType requestAccountType();
}
