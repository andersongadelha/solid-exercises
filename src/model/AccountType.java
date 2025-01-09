package model;

public enum AccountType {
    CURRENT_ACCOUNT("Conta corrente"),
    SAVINGS_ACCOUNT("Poupança");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
