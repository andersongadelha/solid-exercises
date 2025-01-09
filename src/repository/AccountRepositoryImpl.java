package repository;

import model.Account;
import util.AccountUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountRepositoryImpl implements AccountRepository {
    private static final String ACCOUNT_FILE = "accounts.txt";
    private final File file;

    public AccountRepositoryImpl() {
        this.file = new File(ACCOUNT_FILE);
    }

    @Override
    public void save(Account account) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(AccountUtil.serialize(account));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar conta.");
        }
    }
}
