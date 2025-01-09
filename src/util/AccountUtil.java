package util;

import model.Account;

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
}
