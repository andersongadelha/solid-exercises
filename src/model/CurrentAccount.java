package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrentAccount extends Account {

    public CurrentAccount(User user, int accountNumber, int digit, BigDecimal funds, LocalDate openingDate, AccountType accountType) {
        super(user, accountNumber, digit, funds, openingDate, accountType);
    }

    @Override
    public BigDecimal serviceTaxes() {
        return BigDecimal.ZERO;
    }
}
