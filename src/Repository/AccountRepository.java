package Repository;

import Starts.AlternativStart;
import domain.Account;
import domain.User;
import exeption.AccountExeption;
import exeption.MyExeption;
import menu.ClientMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    public static List<Account> accounts = new ArrayList<>();
    public static String file = "src/data/Account.txt";
    AccountExeption accountExeption = new AccountExeption();
   AlternativStart alternativStart=new AlternativStart();


    @Override
    public String toString() {
        return "AccountRepository{" +
                "accounts=" + accounts +
                '}';
    }
    public List<Account> allUsersPrint() {
        Object object = desirialaiz();
        List<Account> accounts1 = new ArrayList<>();
        if ((object instanceof List<?>)) {
            accounts1 = (List<Account>) object;
        }
        return accounts1;
    }

    public List<Account> allUsers() {
        Object object = accountListWitOutPrint();
        List<Account> accounts1 = new ArrayList<>();
        if ((object instanceof List<?>)) {
            accounts1 = (List<Account>) object;
        }
        return accounts1;
    }

    public Account addUser(Account account) {
        accounts = allUsers();
        accounts.add(account);
        serialaiz(accounts);
        return account;
    }

    public static void serialaiz(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Account> desirialaiz() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (List<Account>) ois.readObject();
            System.out.println(accounts);
        } catch (Throwable e) {
//            throw new ;
        }
        return accounts;
    }


    public List<Account> accountListWitOutPrint() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (List<Account>) ois.readObject();
        } catch (Throwable e) {
//            throw new RuntimeException(e);
        }
        return accounts;
    }

    public List<Account> update() {
        Object o = accountListWitOutPrint();
        if (o instanceof List<?>) {
            accounts = (List<Account>) o;
        }
        return accounts;
    }

    public void saveAccount() {
        serialaiz(accounts);
        update();

    }

    public Account findAccountById(int accountId) {
        List<Account> users = allUsers();
        Optional<Account> account1 = users.stream().filter(account -> ((Integer) account.getId()).
                equals(accountId)).findFirst();
        try {
            if (account1.isEmpty()) {
                accountExeption.foundAccount();
            } else{
                return account1.get();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
            alternativStart.goToMenu();
        }
       return account1.get();
    }

    public void deliteAccount(Account account) {
        accounts = allUsers();
        accounts.remove(account);
        serialaiz(accounts);
        update();
    }
}
