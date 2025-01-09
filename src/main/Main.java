package main;

import factories.AccountFactoryRegistry;
import factories.CurrentAccountFactory;
import factories.SavingsAccountFactory;
import model.AccountType;
import repository.AccountRepository;
import repository.AccountRepositoryImpl;
import service.AccountService;
import service.AccountServiceImpl;
import static util.InputUtil.getPositiveInteger;

import java.util.Scanner;

public class Main {

    private static final int EXIT_OPTION = 7;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository, scanner);
        AccountFactoryRegistry.registerFactory(AccountType.CURRENT_ACCOUNT, new CurrentAccountFactory());
        AccountFactoryRegistry.registerFactory(AccountType.SAVINGS_ACCOUNT, new SavingsAccountFactory());

        int option;

        do {
            System.out.println("Sistema de Gerenciamento de contas");
            System.out.println("1. Criar uma conta");
            System.out.println("2. Listar contas");
            System.out.println("3. Realizar saque");
            System.out.println("4. Realizar uma transferência");
            System.out.println("5. Excluir conta");
            System.out.println("6. Relatório de estatísticas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            option = getPositiveInteger(scanner);

            switch (option) {
                case 1:
                    accountService.addAccount();
                    break;
                case 2:
                    accountService.listAccounts();
                    break;
                case 3:
                    System.out.println("3. realizar saque");
                    break;
                case 4:
                    System.out.println("4. realizar uma transferência");
                    break;
                case 5:
                    System.out.println("5. Excluir conta");
                    break;
                case 6:
                    System.out.println("6. Relatório de estatísticas");
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (EXIT_OPTION != option);

        scanner.close();
    }

}