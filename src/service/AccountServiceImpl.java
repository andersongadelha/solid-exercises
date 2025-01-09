package service;

import factories.AccountFactory;
import factories.AccountFactoryRegistry;
import model.Account;
import model.AccountType;
import repository.AccountRepository;
import util.InputUtil;
import static util.InputUtil.getAccountType;
import static util.InputUtil.getNonEmptyInput;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final Scanner scanner;

    public AccountServiceImpl(AccountRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    @Override
    public void addAccount() {
        System.out.print("Digite o nome da pessoa titular da conta: ");
        String ownerName = getNonEmptyInput(scanner);
        System.out.println("Digite quanto vai depositar para abrir a conta: ");
        int funds = InputUtil.getPositiveInteger(scanner);
        int accountNumber = generateAccountNumber();
        int digit = generateAccountDigit();

        System.out.print("Digite o tipo de conta dentre os tipos disponíveis ");
        System.out.print("( ");
        Arrays.stream(AccountType.values()).forEach(accountType -> System.out.print(accountType.getDescription() + "; "));
        System.out.print("): ");
        AccountType accountType = getAccountType(scanner);
        LocalDate openingDate = LocalDate.now();

        try {
            AccountFactory factory = AccountFactoryRegistry.getFactory(accountType);
            Account newAccount = factory.create(ownerName, accountNumber, digit, funds, openingDate, accountType);
            repository.save(newAccount);
            System.out.println("Conta criada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar a conta: " + e.getMessage());
        }
    }

    private int generateAccountNumber() {
        return (int) (Math.random() * 1000);
    }

    private int generateAccountDigit() {
        return (int) (Math.random() * 10);
    }
}
