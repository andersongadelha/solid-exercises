package util;

import model.AccountType;

import java.util.Arrays;

/**
 * Account Type Util
 *
 * <p> Essa classe util tem como objetivo auxiliar na manipulação de AccountType</p>
 *
 * @author Anderson Gadelha
 */
public class AccountTypeUtil {

    /**
     * Função para receber uma string e retornar uma AccountType correspondente.
     *
     * @param string
     * @return AccountType ou null caso não encontre description correspondente a string
     */
    public static AccountType getTypeByDescription(String string) {
        for (AccountType type : AccountType.values()) {
            if (type.getDescription().equalsIgnoreCase(string)) {
                return type;
            }
        }
        System.out.print("Tipos de conta disponíveis ");
        System.out.print("( ");
        Arrays.stream(AccountType.values()).forEach(accountType -> System.out.print(accountType.getDescription() + "; "));
        System.out.print("): ");

        return null;
    }
}
