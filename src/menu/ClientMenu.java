package menu;

import Interface.AccountService;
import Interface.OperatorService;
import Interface.UserService;
import Interface.impl.AccountServiseIMP;
import Interface.impl.OperationServiceIMP;
import Interface.impl.UserServiseIMP;
import Repository.AccountRepository;
import Repository.CourseRepository;
import Starts.AlternativStart;
import domain.Account;
import domain.User;

import java.util.Scanner;

public class ClientMenu {
    private AccountService accountService;
    private UserService userService;
    private OperatorService operatorService;
    AccountServiseIMP accountServiseIMP = new AccountServiseIMP();
    UserServiseIMP userServiseIMP = new UserServiseIMP();
    OperationServiceIMP operationServiceIMP = new OperationServiceIMP();
    AccountRepository accountRepository = new AccountRepository();
    CourseRepository courseRepository = new CourseRepository();
    AlternativStart alternativStart = new AlternativStart();


    public ClientMenu() {
    }

    public ClientMenu(AccountService accountService, UserService userService, OperatorService operatorService) {
        this.accountService = accountService;
        this.userService = userService;
        this.operatorService = operatorService;
    }

    public void goToMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("" +
                "1. Обмен валюты \n" +
                "2. Перевод средств на другой счёт\n" +
                "3. Просмотр баланса на счетах\n" +
                "4. Просмотр текущих курсов\n" +
                "5. Создание счёта \n" +
                "6. Внесение денег на счёт.\n" +
                "7. Удаление счёта\n" +
                "8. Смена пароля\n" +
                "9. Смена логина\n" +
                "10. Подсчёт общей суммы на счетах в BYN\n" +
                "11. Поиск операций текущего пользователя за временной диапазон (история)\n" +
                "12. Выход\n");
        String variant = scanner.nextLine();


        switch (variant) {
            case "1":
                System.out.println("С какого счета вы хотите перевести дегьги? ");
                accountServiseIMP.getAccountByClient(user.getId());
                int i1 = scanner.nextInt();
                System.out.println("На каком счета вы хотите поменять валюту");
                int i2 = scanner.nextInt();
                System.out.println("Какую сумму вы хотите перевести?");
                int money2 = scanner.nextInt();
                accountServiseIMP.changeCourse(i1, i2, money2, user);
                Account accountToOperation = accountRepository.findAccountById(i1);
                Account accountSend = accountRepository.findAccountById(i2);
                operationServiceIMP.creatOperation(user, accountToOperation, money2, accountSend);
                goToMenu(user);
                break;
            case "2":
                System.out.println("Выберите id карты с которой вы хотите перевести деньги: ");
                accountServiseIMP.getAccountByClient(user.getId());
                int id1 = scanner.nextInt();
                System.out.println("напишите id счета на который вы хотите переести средства: ");
                int id2 = scanner.nextInt();
                System.out.println("напишите сумму перевода ");
                double money1 = scanner.nextInt();
                accountServiseIMP.goMoneytoOtherAc(id1, id2, money1, user);
                Account accountToOperation1 = accountRepository.findAccountById(id1);
                Account accountSend1 = accountRepository.findAccountById(id2);
                operationServiceIMP.creatOperation(user, accountToOperation1, money1, accountSend1);
                goToMenu(user);

                break;
            case "3":
                accountServiseIMP.getAccountByClient(user.getId());
                goToMenu(user);


                break;
            case "4":
                System.out.println(courseRepository.desirialaiz());
                goToMenu(user);


                break;
            case "5":

                Account account = new AccountServiseIMP().creatAccount(user.getId(), "1", "BYN");
                System.out.println("вы успешно создали счет" + account);
                goToMenu(user);


                break;
            case "6":

                System.out.println("Выберите карточку для пополнения(введите id): ");
                accountServiseIMP.getAccountByClient(user.getId());
                int accountID = scanner.nextInt();
                System.out.println("Какую сумму вы хотите положить?");
                int money = scanner.nextInt();
                Account account1 = new AccountServiseIMP().passMoney(accountID, money);
                goToMenu(user);

                break;
            case "7":
                System.out.println("Введите id счета, которых хотите удалить: ");
                int accountId = scanner.nextInt();
                accountServiseIMP.deliteAccount(accountId,user.getId());
                goToMenu(user);


                break;
            case "8":
                System.out.println(" введите ваш логин: ");
                String login1 = scanner.nextLine();
                System.out.println(" введите ваш старый пароль: ");
                String passwordOld = scanner.nextLine();
                System.out.println(" придумайте новый пароль: ");
                String passwordNew = scanner.nextLine();
                userServiseIMP.changePassword(login1, passwordOld, passwordNew, user);

                goToMenu(user);

                break;
            case "9":
                System.out.println(" введите ваш логин: ");
                String login2 = scanner.nextLine();
                System.out.println(" введите ваш  пароль: ");
                String passwordOLd = scanner.nextLine();
                System.out.println(" придумайте новый логин: ");
                String loginNEW = scanner.nextLine();
                userServiseIMP.changeLogin(login2, passwordOLd, loginNEW, user);

                goToMenu(user);

                break;
            case "10":
                accountServiseIMP.getALLdeposit(user.getId());
                goToMenu(user);
                break;
            case "11":
                operationServiceIMP.getOperationbyClient(user.getId());
                goToMenu(user);
                break;
            case "12":
                alternativStart.goToMenu();

                break;

            default:
                goToMenu(user);

                System.out.println("Выберите вариант !");

        }

    }
}
