package bankapp.transaction;

import bankapp.dao.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransactionListingService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findTransactionsByAccountId(accountId);
    }
}
