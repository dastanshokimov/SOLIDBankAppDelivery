package bankapp.dao;

import bankapp.account.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long accountId);

    //public void updateAccountBalanceByAccountId(Long accountId, double balance);

/*
    @Modifying
    @Query(
            "INSERT INTO ACCOUNT (account_id, account_type, client_id, balance, withdraw_allowed) " +
                    "VALUES (:accountId, :type, :clientId, :balance, :isWithdrawAllowed)"
    )
    public void addAccount(long accountId, String type, String clientId, double balance, int isWithdrawAllowed);

    @Query("SELECT * FROM ACCOUNT WHERE client_id = :clientId")
    public Iterable<Account> findAccountsByClientId(String clientId);

    @Query("SELECT * FROM ACCOUNT WHERE client_id=:clientId order by balance")
    public Iterable<Account> findAccountsOrderByBalance(String clientId);

    @Modifying
    @Query("UPDATE ACCOUNT a SET a.balance= :amount WHERE a.account_id= :accountId")
    public void updateAccountById(long accountId, double amount);

    @Query("SELECT * FROM ACCOUNT WHERE client_id=:clientId AND account_type=:type")
    Iterable<Account> findAccountsByType(String clientId, String type);

 */
}
