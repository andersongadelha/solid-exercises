package factories;

import model.Account;
import model.AccountType;
import model.CurrentAccount;

import java.time.LocalDate;

public class CurrentAccountFactory implements AccountFactory {
    @Override
    public Account create(String ownerName, int number, int digit, double funds, LocalDate openingDate, AccountType accountType) {
        return new CurrentAccount(ownerName, number, digit, funds, openingDate, accountType);
    }
}
