package Interface.impl;

import Interface.AccountService;
import Repository.AccountRepository;
import Repository.CourseRepository;
import baza.Course1;
import domain.Account;
import domain.User;
import exeption.AccountExeption;
import exeption.MyExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServiseIMP implements AccountService {
    Scanner sc = new Scanner(System.in);
    List<Account> accounts = new ArrayList<>();
    AccountRepository accountRepository = new AccountRepository();
    AccountExeption accountExeption = new AccountExeption();
    Account account = new Account();
    CourseIMP courseIMP = new CourseIMP();
    CourseRepository courseRepository = new CourseRepository();
    private Double comission = 0.01;

    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        this.comission = comission;
    }

    @Override
    public Account creatAccount(int userId, String accountNumer, String currency) {
        Scanner sc = new Scanner(System.in);
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account();
        account.setUserId(userId);
        System.out.println("Выберите валюту: BYN, EUR, RUB, USD");
        account.setCurrency(sc.nextLine());
        System.out.println("Дайте название своей карточки: ");
        account.setAccountNumer(sc.nextLine());
        account.setValue(0.0);
        account.setId(accountRepository.allUsers().size() + 2);
        accountRepository.addUser(account);


        return account;
    }

    @Override
    public Account passMoney(int accountId, double money) {

        Account account1 = accountRepository.findAccountById(accountId);
        account1.setValue(account1.getValue() + money);
        accountRepository.saveAccount();

        return account1;
    }

    public Account deliteMoney(int accountId, double money) {

        Account account1 = accountRepository.findAccountById(accountId);
        try {
            if (account1.getValue() - money > 0) {
                account1.setValue(account1.getValue() - money);
                accountRepository.saveAccount();
            } else {
                accountExeption.cashExeption();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
        }

        return account1;
    }

    public Account getMoney(int accountId, double money) {
        Account account1 = accountRepository.findAccountById(accountId);
        account1.setValue(account1.getValue() + money);
        accountRepository.saveAccount();

        return account1;
    }

    public void goMoneytoOtherAc(int accountId1, int accountId2, double money, User user) {

        Account account1 = deliteMoney(accountId1, money);
        Account account2 = accountRepository.findAccountById(accountId2);

        try {

            if (user.getId() == account1.getUserId() && account1.getValue() > money) {
                comissionBANK(account1.getId(), money);
                double comission = money * 0.01;
                money = money - comission;

                if (account1.getUserId() == account2.getUserId() && account1.getCurrency().equals(account2.getCurrency())) {
                    account2.setValue(account2.getValue() + money);
                    System.out.println(" вы перевели на свой счет " + money + account2.getCurrency());

                } else if (!account1.getCurrency().equals(account2.getCurrency())) {
                    System.out.println("У другого счета иная валюта, перейдите в валютные операции");
                    account1 = getMoney(accountId1, money);
                } else {
                    System.out.println(" вы перевели на счет " + account2.getId() + " " + money + account2.getCurrency());
                    account2.setValue(account2.getValue() + money);
                }
            } else {
                accountExeption.privetExeption();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
        }

        accountRepository.saveAccount();

    }

    @Override
    public List<Account> getAccountByClient(int userId) {
        List<Account> users = accountRepository.accountListWitOutPrint();
        List<Account> accounts1 = users.stream().filter(account -> ((Integer) account.getUserId()).equals((Integer) userId)).toList();
        System.out.println(accounts1);
        return accounts1;
    }
    public List<Account> allMoneyinBank() {
        Course1 course1 = courseIMP.course();
        List<Account> accounts1 = accountRepository.accountListWitOutPrint();
        double sum = 0;
        for (int i = 0; i < accounts1.size(); i++) {
            if (accounts1.get(i).getCurrency().equals("BYN")) {
                sum += accounts1.get(i).getValue();
            } else if (accounts1.get(i).getCurrency().equals("EUR")) {
                double eur1 = accounts1.get(i).getValue() * course1.getEurToByn();
                sum += eur1;
            } else if (accounts1.get(i).getCurrency().equals("USD")) {
                double usd1 = accounts1.get(i).getValue() * course1.getByn();
                sum += usd1;
            } else if (accounts1.get(i).getCurrency().equals("RUB")) {
                double rub1 = accounts1.get(i).getValue() * course1.getRubToByn();
                sum += rub1;
            }
        }
        System.out.println("Общая сумма денег в банке: " + sum+ "BYN");
        return accounts1;
    }

    public List<Account> getALLdeposit(int userId) {
        Course1 course1 = courseIMP.course();
        List<Account> users = accountRepository.accountListWitOutPrint();
        List<Account> accounts1 = users.stream().filter(account -> ((Integer) account.getUserId())
                .equals((Integer) userId)).toList();
        double sum = 0;
        for (int i = 0; i < accounts1.size(); i++) {
            if (accounts1.get(i).getCurrency().equals("BYN")) {
                sum += accounts1.get(i).getValue();
            } else if (accounts1.get(i).getCurrency().equals("EUR")) {
                double eur1 = accounts1.get(i).getValue() * course1.getEurToByn();
                sum += eur1;
            } else if (accounts1.get(i).getCurrency().equals("USD")) {
                double usd1 = accounts1.get(i).getValue() * course1.getByn();
                sum += usd1;
            } else if (accounts1.get(i).getCurrency().equals("RUB")) {
                double rub1 = accounts1.get(i).getValue() * course1.getRubToByn();
                sum += rub1;
            }
        }
        System.out.println("обшая сумма в BYN: " + sum);
        return accounts1;
    }


    public void allUsers() {
        accountRepository.allUsersPrint();
    }

    public void deliteAccount(int accountId, int userId) {
        Account account1 = accountRepository.findAccountById(accountId);
        try {


        if (account1.getUserId() == userId) {
            accountRepository.deliteAccount(account1);
            accountRepository.saveAccount();
            System.out.println("вы успешно удалили " + account1.getAccountNumer());
        }else {
         accountExeption.privetExeption();
        }} catch (MyExeption e) {
            e.printStackTrace();
        }
    }

    public void changeCourse(int id1, int id2, double money, User user) {
        Course1 course1 = courseIMP.course();

        double byn = course1.getByn();
        double usd = course1.getUsd();
        double eur = course1.getEur();
        double rub = course1.getRub();
        double rubToUsd = usd / rub;
        double rubToByn = byn / rub;
        double rubToEur = eur / rub;
        double usdToRub = rub / usd;
        double usdToByn = byn / usd;
        double usdToEur = eur / usd;
        double bynToUsd = usd / byn;
        double bynToRub = rub / byn;
        double bynToEur = eur / byn;
        double eurToUsd = usd / eur;
        double eurToRub = rub / eur;
        double eurToByn = byn / eur;
        Account account1 = accountRepository.findAccountById(id1);
        Account account2 = accountRepository.findAccountById(id2);


        try {
            if (user.getId() == account1.getUserId() && account1.getValue() > money) {
                comissionBANK(id1, money);
                double comission = money * 0.01;
                money = money - comission;
                account1 = deliteMoney(id1, money);
                switch (account1.getCurrency()) {

                    case "BYN":

                        if (account2.getCurrency().equals("BYN")) {
                            System.out.println("Сумма перевода " + money+"BYN");
                        } else if (account2.getCurrency().equals("USD")) {
                            money = money / byn;
                            System.out.println("Сумма перевода " + money+"USD");
                        } else if (account2.getCurrency().equals("EUR")) {
                            money = money / eurToByn;
                            System.out.println("Сумма перевода " + money+"EUR");
                        } else if (account2.getCurrency().equals("RUB")) {
                            money = money / rubToByn;
                            System.out.println("Сумма перевода " + money +"RUB");
                        }
                        account2 = getMoney(id2, money);
                        break;
                    case "EUR":
                        if (account2.getCurrency().equals("BYN")) {
                            money = money * eurToByn;
                            System.out.println("Сумма перевода " + money+"BYN");
                        } else if (account2.getCurrency().equals("USD")) {
                            money = money / eur;
                            System.out.println("Сумма перевода " + money+"USD");

                        } else if (account2.getCurrency().equals("EUR")) {
                            System.out.println("Сумма перевода " + money+"EUR");

                        } else if (account2.getCurrency().equals("RUB")) {
                            money = money * eurToRub;
                            System.out.println("Сумма перевода " + money +"RUB");
                        }
                        account2 = getMoney(id2, money);
                        break;
                    case "USD":
                        if (account2.getCurrency().equals("BYN")) {
                            money = money * usdToByn;
                            System.out.println("Сумма перевода " + money+"BYN");
                        } else if (account2.getCurrency().equals("USD")) {
                            System.out.println("Сумма перевода " + money+"USD");
                        } else if (account2.getCurrency().equals("EUR")) {
                            money = money * usdToEur;
                            System.out.println("Сумма перевода " + money+"EUR");
                        } else if (account2.getCurrency().equals("RUB")) {
                            money = money * usdToRub;
                            System.out.println("Сумма перевода " + money +"RUB");
                        }
                        account2 = getMoney(id2, money);
                        break;
                    case "RUB":
                        if (account2.getCurrency().equals("BYN")) {
                            money = money * bynToRub;
                            System.out.println("Сумма перевода " + money+"BYN");
                        } else if (account2.getCurrency().equals("USD")) {
                            money = money / usdToRub;
                            System.out.println("Сумма перевода " + money+"USD");
                        } else if (account2.getCurrency().equals("EUR")) {
                            money = money / eurToRub;
                            System.out.println("Сумма перевода " + money+"EUR");
                        } else if (account2.getCurrency().equals("RUB")) {
                            System.out.println("Сумма перевода " + money+"RUB");
                        }
                        account2 = getMoney(id2, money);
                        break;
                    default:
                        System.out.println("Выберите вариант !");
                }
            } else {

                accountExeption.privetExeption();
            }

        } catch (MyExeption e) {
            e.printStackTrace();
        }
        accountRepository.saveAccount();


    }

    public Account changidAccount(int id, int id2) {
        Account account1 = accountRepository.findAccountById(id);
        account1.setId(id2);
        accountRepository.saveAccount();
        return account1;
    }

    public double comissionBANK(int id, double money) {
        Course1 course1 = courseIMP.course();
        Account account3 = accountRepository.findAccountById(0);
        double comission = 0;

        Account account1 = accountRepository.findAccountById(id);
        if (account1.getCurrency().equals("BYN")) {
            comission = (money * 0.01);
            System.out.println("комиссия составила " + comission+"  BYN");
            account3 = getMoney(account3.getId(), comission);

        } else if (account1.getCurrency().equals("USD")) {
            comission = ((money * 0.01)) * course1.getByn();
            System.out.println("комиссия составила " + comission+"  BYN");
            account3 = getMoney(account3.getId(), comission);

        } else if (account1.getCurrency().equals("EUR")) {
            comission = (money * 0.01) * course1.getEurToByn();
            System.out.println("комиссия составила " + comission+"  BYN");
            account3 = getMoney(account3.getId(), comission);
        } else if (account1.getCurrency().equals("RUB")) {
            comission = (money * 0.01) * course1.getRubToByn();
            account3 = getMoney(account3.getId(), comission);
            System.out.println("комиссия составила " + comission+"  BYN");
        } else {
            System.out.println(" Не правильно выбранна валюта");
        }
        return comission;

    }

    public double comissionBANKtoOperation(int id, double money) {
        Course1 course1 = courseIMP.course();
        Account account3 = accountRepository.findAccountById(0);
        double comission = 0;

        Account account1 = accountRepository.findAccountById(id);
        if (account1.getCurrency().equals("BYN")) {
            comission = (money * 0.01);
//            System.out.println("комиссия составила "+comission);
            account3 = getMoney(account3.getId(), comission);

        } else if (account1.getCurrency().equals("USD")) {
            comission = ((money * 0.01)) * course1.getByn();
//            System.out.println("комиссия составила "+comission);
            account3 = getMoney(account3.getId(), comission);

        } else if (account1.getCurrency().equals("EUR")) {
            comission = (money * 0.01) * course1.getEurToByn();
//            System.out.println("комиссия составила "+comission);
            account3 = getMoney(account3.getId(), comission);
        } else if (account1.getCurrency().equals("RUB")) {
            comission = (money * 0.01) * course1.getRubToByn();
            account3 = getMoney(account3.getId(), comission);
//            System.out.println("комиссия составила "+comission);
        } else {
//            System.out.println(" Не правильно выбранна валюта");
        }
        return comission;

    }
}
