package service;

import factories.AccountFactory;
import factories.AccountFactoryRegistry;
import model.Account;
import model.AccountType;
import model.User;
import repository.AccountRepository;
import util.InputUtil;
import static util.InputUtil.getAccountType;
import static util.InputUtil.getCPF;
import static util.InputUtil.getEmail;
import static util.InputUtil.getNonEmptyInput;
import static util.InputUtil.getPhoneNumber;
import util.LocalDateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final Scanner scanner;
    private final NotificationService notificationService;

    public AccountServiceImpl(AccountRepository repository, Scanner scanner, NotificationService notificationService) {
        this.repository = repository;
        this.scanner = scanner;
        this.notificationService = notificationService;
    }

    @Override
    public void addAccount() {
        System.out.print("Digite o nome da pessoa titular da conta: ");
        String ownerName = getNonEmptyInput(scanner);
        String email = getEmail(scanner);
        String phoneNumber = getPhoneNumber(scanner);
        String cpf = getCPF(scanner);

        User user = new User(ownerName, cpf, email, phoneNumber);
        System.out.println("Digite quanto vai depositar para abrir a conta: ");
        BigDecimal funds = InputUtil.getPositiveBigDecimal(scanner);
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
            Account newAccount = factory.create(user, accountNumber, digit, funds, openingDate, accountType);
            repository.save(newAccount);
            System.out.println("Conta criada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar a conta: " + e.getMessage());
        }
    }

    @Override
    public void listAccounts() {
        List<Account> videos = repository.findAll();
        videos.forEach(this::showDetails);
    }

    @Override
    public void withDraw() {
        System.out.println("Digite o numero da conta com digito que deseja realizar o saque (xxx-x): ");
        String fullAccountNumber = InputUtil.getNonEmptyInput(scanner);
        try {
            Account account = repository.findByFullAccountNumber(fullAccountNumber);
            System.out.println("Digite a quantidade de deseja sacar: ");
            BigDecimal value = InputUtil.getPositiveBigDecimal(scanner);
            account.withDraw(value);
            repository.updateFunds(account);
        } catch (Exception e) {
            System.out.println("Erro ao realizar saque: " + e.getMessage());
        }
        System.out.println("Saque realizado com sucesso.");
    }

    @Override
    public void deposit() {
        System.out.println("Digite o numero da conta com digito que deseja realizar o deposito (xxx-x): ");
        String fullAccountNumber = InputUtil.getNonEmptyInput(scanner);
        try {
            Account account = repository.findByFullAccountNumber(fullAccountNumber);
            System.out.println("Digite a quantidade de deseja depositar: ");
            BigDecimal value = InputUtil.getPositiveBigDecimal(scanner);
            account.deposit(value);
            repository.updateFunds(account);
        } catch (Exception e) {
            System.out.println("Erro ao realizar deposito: " + e.getMessage());
        }
        System.out.println("Deposito realizado com sucesso.");
    }

    @Override
    public void transfer() {
        System.out.println("Primeiro digite o numero da conta que vai ter o saldo subtraído");
        System.out.println("Digite o numero da conta com digito (xxx-x): ");
        String fullAccountNumberWithDraw = InputUtil.getNonEmptyInput(scanner);
        try {
            Account accountWithDraw = repository.findByFullAccountNumber(fullAccountNumberWithDraw);
            System.out.println("Digite agora a conta que vai receber a transferência");
            System.out.println("Digite o numero da conta com digito (xxx-x): ");
            String fullAccountNumberDeposit = InputUtil.getNonEmptyInput(scanner);
            Account accountDeposit = repository.findByFullAccountNumber(fullAccountNumberDeposit);
            System.out.println("Digite a quantidade de deseja transferir: ");
            BigDecimal value = InputUtil.getPositiveBigDecimal(scanner);
            BigDecimal taxes = accountWithDraw.serviceTaxes();
            accountWithDraw.withDraw(value.add(taxes));
            accountDeposit.deposit(value);
            repository.updateFunds(accountWithDraw);
            repository.updateFunds(accountDeposit);

            notificationService.notify(accountDeposit.getUser());
        } catch (Exception e) {
            System.out.println("Erro ao realizar deposito: " + e.getMessage());
        }
        System.out.println("Deposito realizado com sucesso.");
    }

    private int generateAccountNumber() {
        return (int) (Math.random() * 1000);
    }

    private int generateAccountDigit() {
        return (int) (Math.random() * 10);
    }

    private void showDetails(Account account) {
        System.out.println("Titular:" + account.getUser().getName());
        System.out.println("CPF:" + account.getUser().getCpf());
        System.out.println("E-mail:" + account.getUser().getEmail());
        System.out.println("Telefone:" + account.getUser().getPhoneNumber());
        System.out.println("Numero da conta:" + account.getAccountNumber());
        System.out.println("Digito: " + account.getDigit());
        System.out.println("Tipo de conta: " + account.getAccountType().getDescription());
        System.out.println("Saldo: " + account.getFunds());
        System.out.println("Data de abertura da conta: " + LocalDateUtil.serialize(account.getOpeningDate()));
        System.out.println();
    }
}
