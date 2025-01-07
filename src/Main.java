import static util.InputUtil.getPositiveInteger;

import java.util.Scanner;

public class Main {
    private static final int EXIT_OPTION = 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== Sistema de Gerenciamento de contas ===");
            System.out.println("1. criar uma conta");
            System.out.println("2. listar contas");
            System.out.println("3. realizar saque");
            System.out.println("4. realizar uma transferência");
            System.out.println("5. Excluir conta");
            System.out.println("6. Relatório de estatísticas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            option = getPositiveInteger(scanner);

            switch (option) {
                case 1:
                    System.out.println("1. criar uma conta");
                    break;
                case 2:
                    System.out.println("2. listar contas");
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