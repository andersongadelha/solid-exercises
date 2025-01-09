package model;

import java.time.LocalDate;

public class SavingsAccount extends Account {

    public SavingsAccount(String owner, int accountNumber, int digit, double funds, LocalDate openingDate, AccountType accountType) {
        super(owner, accountNumber, digit, funds, openingDate, accountType);
    }

    @Override
    public double serviceTaxes() {
        return 15;
    }
}
