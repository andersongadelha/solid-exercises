package repository;

import model.Account;

import java.util.List;

public interface AccountRepository {
    void save(Account account);
    List<Account> findAll();
    Account findByFullAccountNumber(String fullAccountNumber);
    void updateFunds(Account account);
}
