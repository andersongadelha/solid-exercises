package model;

import java.time.LocalDate;

public abstract class Account {

    private String ownerName;
    private int accountNumber;
    private int digit;
    private double funds;
    private LocalDate openingDate;
    private AccountType accountType;

    public Account(String ownerName, int accountNumber, int digit, double funds, LocalDate openingDate, AccountType accountType) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.digit = digit;
        this.funds = funds;
        this.openingDate = openingDate;
        this.accountType = accountType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getDigit() {
        return digit;
    }

    public double getFunds() {
        return funds;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void deposit(double value) {
        funds += value;
    }

    public void withDraw(double value) {
        funds -= value;
    }

    public abstract double serviceTaxes();

}
