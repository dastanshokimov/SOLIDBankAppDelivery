package bankapp.service;

import bankapp.dao.AccountRepository;
import lombok.AllArgsConstructor;

public interface AccountDeletionService {
    public void deleteAccountById(Long accountId);
}
