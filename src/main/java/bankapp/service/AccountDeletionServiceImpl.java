package bankapp.service;

import bankapp.dao.AccountRepository;
import bankapp.exception.AccountNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;

@Service
@AllArgsConstructor
public class AccountDeletionServiceImpl implements AccountDeletionService {
    private AccountRepository accountRepository;

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepository.findById(accountId)
                        .orElseThrow(() -> new AccountNotFoundException(accountId));
        accountRepository.deleteById(accountId);
    }
}
