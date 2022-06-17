package bankapp.cli;

import bankapp.account.Account;
import bankapp.service.AccountListingService;
import bankapp.account.AccountWithdraw;
import bankapp.transaction.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public void withdrawMoney(String clientId) {
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        Long accountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account accountWithdraw = null;

        if(accountId>0)
            accountWithdraw = accountListing.getClientWithdrawAccount(clientId, accountId);

        if(accountWithdraw.isWithdrawAllowed())
            transactionWithdraw.execute(amount, accountWithdraw);
        else
            System.out.println("withdraw NOT allowed on FIXED account");
    }
}
