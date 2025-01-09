package model;

import java.time.LocalDate;

public class CurrentAccount extends Account {

    public CurrentAccount(String owner, int accountNumber, int digit, double funds, LocalDate openingDate, AccountType accountType) {
        super(owner, accountNumber, digit, funds, openingDate, accountType);
    }

    @Override
    public double serviceTaxes() {
        return 0;
    }
}
