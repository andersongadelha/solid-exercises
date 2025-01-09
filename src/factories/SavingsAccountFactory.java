package factories;

import model.Account;
import model.AccountType;
import model.SavingsAccount;

import java.time.LocalDate;

public class SavingsAccountFactory implements AccountFactory {
    @Override
    public Account create(String ownerName, int number, int digit, double funds, LocalDate openingDate, AccountType accountType) {
        return new SavingsAccount(ownerName, number, digit, funds, openingDate, accountType);
    }
}
