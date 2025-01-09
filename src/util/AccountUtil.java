package util;

import factories.AccountFactory;
import factories.AccountFactoryRegistry;
import model.Account;
import model.AccountType;

import java.time.LocalDate;

/**
 * Account Util
 *
 * <p> Essa classe util tem como objetivo auxiliar na manipulação de Account</p>
 *
 * @author Anderson Gadelha
 */
public class AccountUtil {

    /**
     * Função para receber uma Account e retornar uma string no formato CSV.
     *
     * @param account
     *
     * @return Uma String no formato CSV representando account.
     */
    public static String serialize(Account account) {
        return String.join(
                ";",
                account.getOwnerName(),
                String.valueOf(account.getAccountNumber()),
                String.valueOf(account.getDigit()),
                String.valueOf(account.getFunds()),
                LocalDateUtil.serialize(account.getOpeningDate()),
                account.getAccountType().name());
    }

    /**
     * Função para receber uma string no formato CSV e retorna uma account dinamicamente.
     *
     * @param string
     *
     * @return Account ou null caso não consiga desserializar
     */
    public static Account deserialize(String string) {
        try {
            String[] parts = string.split(";");
            AccountType accountType = AccountType.valueOf(parts[5]);
            AccountFactory factory = AccountFactoryRegistry.getFactory(accountType);

            String ownerName = parts[0];
            int accountNumber = Integer.parseInt(parts[1]);
            int digit = Integer.parseInt(parts[2]);
            double funds = Double.parseDouble(parts[3]);
            LocalDate openingDate = LocalDateUtil.deserialize(parts[4]);

            return factory.create(ownerName, accountNumber, digit, funds, openingDate, accountType);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar conta: " + e.getMessage());
            return null;
        }
    }
}
