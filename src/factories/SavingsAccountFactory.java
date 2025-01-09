package factories;

import model.Account;
import model.AccountType;
import model.SavingsAccount;
import model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account create(User user, int number, int digit, BigDecimal funds, LocalDate openingDate, AccountType accountType) {
        return new SavingsAccount(user, number, digit, funds, openingDate, accountType);
    }
}
