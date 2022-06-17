package bankapp.controller;

import bankapp.account.Account;
import bankapp.exception.AccountResponse;
import bankapp.service.*;
import bankapp.transaction.Transaction;
import bankapp.transaction.TransactionDeposit;
import bankapp.transaction.TransactionListingService;
import bankapp.transaction.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountListingService accountListingService;
    private AccountDeletionService accountDeletionService;
    private AccountCreationServiceWeb accountCreationService;
    private TransactionDeposit transactionDeposit;
    private TransactionWithdraw transactionWithdraw;

    private TransactionListingService transactionListingService;

    @GetMapping
    public List<Account> getStudents() {
        return accountListingService.getClientAccounts("1");
    }

    @PostMapping
    public ResponseEntity<Object> addNewAccount(@RequestBody Account account) {
        Long accountId = -1l;
        try {
            accountId = accountCreationService.createAccount(account);

        } catch (Exception e) {
            return new ResponseEntity<>("{message: Account not specified correctly }", HttpStatus.BAD_REQUEST);
        }
        String accountNumber = String.format("%03d%06d", 1, Integer.parseInt(accountId+""));
        return new ResponseEntity<>(new AccountResponse("Account " + accountNumber + " created", HttpStatus.OK), HttpStatus.OK);

    }
    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable("accountId") Long accountId) {
        return accountListingService.getClientAccountById("1", accountId);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Object> deleteAccountById(@PathVariable("accountId") Long accountId) {
        accountDeletionService.deleteAccountById(accountId);
        return new ResponseEntity<>(new AccountResponse("Account " + accountId + " deleted", HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<Object> depositAccount(@PathVariable("accountId") Long accountId, @RequestBody Double amount) {
        Account account = accountListingService.getClientAccount("1", accountId);
        transactionDeposit.execute(amount, account);
        return new ResponseEntity<>(new AccountResponse(
                "$" + amount + " transferred to account " + accountId, HttpStatus.OK), HttpStatus.OK);
    }
    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<Object> withdrawAccount(@PathVariable("accountId") Long accountId, @RequestBody Double amount) {
        Account account = accountListingService.getClientAccount("1", accountId);
        transactionWithdraw.execute(amount, account);
        return new ResponseEntity<>(new AccountResponse(
                "$" + amount + " transferred from account " + accountId, HttpStatus.OK), HttpStatus.OK);
    }
    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getTransactionsByAccountId(@PathVariable("accountId") Long accountId) {
        return transactionListingService.getTransactionsByAccountId(accountId);
    }
}
