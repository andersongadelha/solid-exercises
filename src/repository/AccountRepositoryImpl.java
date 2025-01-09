package repository;

import model.Account;
import util.AccountUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Account account = AccountUtil.deserialize(line);
                if (account != null) {
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            System.out.println("Não existem contas cadastradas.");
        }
        return accounts;
    }

    @Override
    public Account findByFullAccountNumber(String fullAccountNumber) {
        List<Account> accounts = findAll();

        return accounts.stream()
                .filter(account -> account.getFullAccountNumber().equalsIgnoreCase(fullAccountNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Não foi encontrada nenhuma conta com esse numero."));
    }

    @Override
    public void updateFunds(Account account) {
        List<Account> allAccounts = findAll();

        List<Account> updatedAccounts = new ArrayList<>(allAccounts.stream()
                .filter(acc -> !acc.getFullAccountNumber().equals(account.getFullAccountNumber()))
                .toList());
        updatedAccounts.add(account);

        saveAccounts(updatedAccounts);
    }

    private void saveAccounts(List<Account> updatedAccounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Account account : updatedAccounts) {
                bw.write(AccountUtil.serialize(account));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas");
        }
    }
}
