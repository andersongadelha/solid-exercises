package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingsAccount extends Account {

    public SavingsAccount(User user, int accountNumber, int digit, BigDecimal funds, LocalDate openingDate, AccountType accountType) {
        super(user, accountNumber, digit, funds, openingDate, accountType);
    }

    @Override
    public double serviceTaxes() {
        return 15;
    }
}
