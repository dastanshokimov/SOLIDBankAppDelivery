package bankapp.cli;

import bankapp.account.Account;
import bankapp.service.AccountListingService;
import bankapp.transaction.TransactionDeposit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public void depositMoney(String clientId) {

        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        long accountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = null;
        if(accountId> 0)
            account = accountListing.getClientAccount(clientId, accountId);
        if(account != null)
            transactionDeposit.execute(amount, account);
        else
            System.out.println("Account not found");
    }
}
