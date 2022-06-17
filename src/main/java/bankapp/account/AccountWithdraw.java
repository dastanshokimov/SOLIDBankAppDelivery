package bankapp.account;

public class AccountWithdraw extends Account {
    public AccountWithdraw(long accountId, AccountType accountType,
                           String clientId, double balance, boolean withdrawAllowed) {
        super(accountId, accountType.getType(), clientId, balance, withdrawAllowed);
    }
}
