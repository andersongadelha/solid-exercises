package factories;

import model.AccountType;

import java.util.HashMap;
import java.util.Map;

public class AccountFactoryRegistry {
    private static final Map<AccountType, AccountFactory> factories = new HashMap<>();

    public static void registerFactory(AccountType type, AccountFactory factory) {
        factories.put(type, factory);
    }

    public static AccountFactory getFactory(AccountType type) {
        if (!factories.containsKey(type)) {
            throw new IllegalArgumentException("Nenhuma factory registrada para o tipo: " + type);
        }
        return factories.get(type);
    }
}