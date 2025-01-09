package factories;

import model.Account;
import model.AccountType;
import model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface AccountFactory {
    Account create(User user, int number, int digit, BigDecimal funds, LocalDate openingDate, AccountType accountType);
}
