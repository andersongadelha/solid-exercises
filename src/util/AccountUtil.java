package util;

import factories.AccountFactory;
import factories.AccountFactoryRegistry;
import model.Account;
import model.AccountType;
import model.User;

import java.math.BigDecimal;
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
                UserUtil.serialize(account.getUser()),
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
            AccountType accountType = AccountType.valueOf(parts[8]);
            AccountFactory factory = AccountFactoryRegistry.getFactory(accountType);

            String userName = parts[0];
            String cpf = parts[1];
            String email = parts[2];
            String phoneNumber = parts[3];
            User user = new User(userName, email, cpf, phoneNumber);

            int accountNumber = Integer.parseInt(parts[4]);
            int digit = Integer.parseInt(parts[5]);
            BigDecimal funds = BigDecimal.valueOf(Double.parseDouble(parts[6]));
            LocalDate openingDate = LocalDateUtil.deserialize(parts[7]);

            return factory.create(user, accountNumber, digit, funds, openingDate, accountType);
        } catch (Exception e) {
            System.out.println("Erro ao desserializar conta: " + e.getMessage());
            return null;
        }
    }
}
