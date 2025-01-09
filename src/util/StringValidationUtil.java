package util;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * String Validation Util
 *
 * <p>Essa classe utilitária tem como objetivo realizar validações em strings, como e-mail, CPF e número de telefone.</p>
 *
 * @author Anderson Gadelha
 */
public class StringValidationUtil {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private static final String CPF_REGEX = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$";

    private static final String PHONE_REGEX = "^\\d{11}$";

    /**
     * Valida se a string fornecida é um e-mail válido.
     *
     * @param email String a ser validada
     * @return true se for um e-mail válido, false caso contrário
     */
    public static boolean isValidEmail(String email) {
        return Objects.nonNull(email) && Pattern.matches(EMAIL_REGEX, email);
    }

    /**
     * Valida se a string fornecida é um CPF válido.
     *
     * @param cpf String a ser validada
     * @return true se for um CPF válido, false caso contrário
     */
    public static boolean isValidCPF(String cpf) {
        return Objects.nonNull(cpf) && Pattern.matches(CPF_REGEX, cpf);
    }

    /**
     * Valida se a string fornecida é um número de telefone válido.
     *
     * @param phoneNumber String a ser validada
     * @return true se for um número de telefone válido, false caso contrário
     */
    public static boolean isValidPhone(String phoneNumber) {
        return Objects.nonNull(phoneNumber) && Pattern.matches(PHONE_REGEX, phoneNumber);
    }
}
