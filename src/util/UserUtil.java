package util;

import model.User;

/**
 * User Util
 *
 * <p>Essa classe util tem como objetivo auxiliar na manipulação de User</p>
 *
 * @author Anderson Gadelha
 */
public class UserUtil {

    /**
     * Função para receber um User e retornar uma string no formato CSV.
     *
     * @param user
     *
     * @return Uma String no formato CSV representando o User.
     */
    public static String serialize(User user) {
        return String.join(
                ";",
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getPhoneNumber());
    }
}
