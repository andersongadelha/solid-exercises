package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Account {

    private User user;
    private int accountNumber;
    private int digit;
    private BigDecimal funds;
    private LocalDate openingDate;
    private AccountType accountType;

    public Account(User user, int accountNumber, int digit, BigDecimal funds, LocalDate openingDate, AccountType accountType) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.digit = digit;
        this.funds = funds;
        this.openingDate = openingDate;
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getDigit() {
        return digit;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getFullAccountNumber() {
        return accountNumber + "-" + digit;
    }

    public void deposit(BigDecimal value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("O valor de deposito não pode ser nulo");
        }
        funds = funds.add(value);
    }

    public void withDraw(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("O valor do saque não pode ser nulo");
        }
        funds = funds.subtract(value);
    }

    public abstract double serviceTaxes();

}
