package util;

import model.AccountType;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

/**
 * Input Util
 *
 * <p> Essa classe util tem como objetivo auxiliar na entrada de inputs</p>
 *
 * @author Anderson Gadelha
 */
public class InputUtil {

    /**
     * Função para receber um input e retornar valor inteiro.
     * Caso seja recebido algum valor diferente de um inteiro menor ou igual a zero a função recebe o input novamente.
     *
     * @param scanner
     *
     * @return Um inteiro maior que zero.
     */
    public static int getPositiveInteger(Scanner scanner) {
        int output = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            try {
                output = Integer.decode(input);
                if (output > 0) {
                    validInput = true;
                } else {
                    System.out.println("A entrada deve ser um valor inteiro maior que zero.");
                }
            } catch (Exception e) {
                System.out.println("A entrada deve ser um valor inteiro maior que zero.");
            }
        }

        return output;
    }

    /**
     * Função para receber um input enquanto a entrada não seja vazia.
     *
     * @param scanner
     *
     * @return Uma String não vazia.
     */
    public static String getNonEmptyInput(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("A entrada não pode ser vazia.");
            }
        } while (input.isEmpty());

        return input;
    }

    /**
     * Função para receber input enquanto a entrada seja inválida para um localDate no formato dd/MM/aaaa.
     *
     * @param scanner
     *
     * @return LocalDate
     */
    public static LocalDate getLocalDate(Scanner scanner) {
        String input;
        LocalDate date = null;
        do {
            input = scanner.nextLine();
            try {
                date = LocalDateUtil.deserialize(input);
                if(date.isAfter(LocalDate.now())) {
                    System.out.println("A data não pode ser no futuro");
                    System.out.println("Digite novamente:1");
                    date = null;
                }
            } catch (Exception e) {
                System.out.println("Digite a data no formato dd/MM/aaaa:");
            }
        } while (Objects.isNull(date));

        return date;
    }

    /**
     * Função para receber input até a entrada ser uma AccountType valida.
     *
     * @param scanner
     *
     * @return AccountType
     */
    public static AccountType getAccountType(Scanner scanner) {
        String input;
        AccountType accountType;
        do {
            input = scanner.nextLine();
            accountType = AccountTypeUtil.getTypeByDescription(input);
        } while (Objects.isNull(accountType));

        return accountType;
    }

}
