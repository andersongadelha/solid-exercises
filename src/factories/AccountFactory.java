package factories;

import model.Account;
import model.AccountType;

import java.time.LocalDate;

public interface AccountFactory {
    Account create(String ownerName, int number, int digit, int funds, LocalDate openingDate, AccountType accountType);
}
