package menu;

import Interface.impl.AccountServiseIMP;
import Interface.impl.CourseIMP;
import Interface.impl.OperationServiceIMP;
import Interface.impl.UserServiseIMP;
import domain.Account;
import domain.User;

import java.util.Scanner;

public class AdminMenu {
    AccountServiseIMP accountServiseIMP=new AccountServiseIMP();
    UserServiseIMP userServiseIMP=new UserServiseIMP();
    OperationServiceIMP operationServiceIMP=new OperationServiceIMP();
    CourseIMP courseIMP=new CourseIMP();
    UserMenu userMenu = new UserMenu(userServiseIMP);

    public  void goToMenu( User user){
        Scanner scanner=new Scanner(System.in);
        System.out.println("" +
                "1. Добавить нового администратора\n"+
                "2. Просмотр всех клиентов\n"+
                "3. Просмотр операций по клиенту\n"+
                "4. Удаление клиента\n"+
                "5. Смена пароля\n"+
                "6. Смена логина\n"+
                "7. Создание счёта\n"+
                "8. Просмотр счёта с комиссиями\n"+
                "9. Изменить курс валют\n"+
                "10. Капитализация банка \n"+
                "11. Изменить id счетa\n"+
                "12. Регистрация пользователя\n"+
                "13. Просмотр клиента по логину\n"+
                "14. Просмотр всех счетов\n"+
                "15. Просмотр всех операций\n"+
                "16. Выход");

        String variant = scanner.nextLine();
        switch (variant){
            case "1":
                System.out.println("Введите логин: ");
                String login =scanner.nextLine();
                System.out.println("Введите пароль: ");
                String password = scanner.nextLine();
                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
                System.out.println("Введите фамилию: ");
                String surname = scanner.nextLine();
                userServiseIMP.register1(login, password,name,surname);
                goToMenu(user);

                break;
            case "2":
                userServiseIMP.allUsers();
                goToMenu(user);

                break;
            case "3":
                System.out.println("введите id клиента: ");
                int idClient = scanner.nextInt();
                operationServiceIMP.getOperationbyClient(idClient);
                goToMenu(user);

                break;
            case "4":
                System.out.println("введите id клиента кторого хотите удалить ");
                int itD=scanner.nextInt();
                userServiseIMP.deliteAccount(itD);
                goToMenu(user);

                break;
            case "5":
                System.out.println(" введите ваш логин: ");
                String login1= scanner.nextLine();
                System.out.println(" введите ваш старый пароль: ");
                String passwordOld= scanner.nextLine();
                System.out.println(" придумайте новый пароль: ");
                String passwordNew= scanner.nextLine();
                userServiseIMP.changePassword(login1,passwordOld,passwordNew, user);
                System.out.println("вы успешно изменили пароль");
                goToMenu(user);


                break;
            case "6":
                System.out.println(" введите ваш логин: ");
                String login2= scanner.nextLine();
                System.out.println(" введите ваш  пароль: ");
                String passwordOLd= scanner.nextLine();
                System.out.println(" придумайте новый логин: ");
                String loginNEW= scanner.nextLine();
                userServiseIMP.changeLogin(login2,passwordOLd,loginNEW,user);

                goToMenu(user);

                break;
            case "7":
                Account account =new AccountServiseIMP().creatAccount(user.getId(),"1","BYN");
                System.out.println("вы успешно создали счет"+ account);
                goToMenu(user);

                break;
            case "8":
                accountServiseIMP.getAccountByClient(user.getId());
                goToMenu(user);

                break;
            case "9":
                System.out.println(" введите курс BYN: ");
                double byn= scanner.nextDouble();
                System.out.println(" введите курс EUR: ");
                double eur= scanner.nextDouble();
                System.out.println(" введите курс USD: ");
                double usd= scanner.nextDouble();
                System.out.println(" введите курс RUB: ");
                double rub= scanner.nextDouble();
                courseIMP.changCourse(byn,eur,usd,rub);
                System.out.println("вы успешно изменили КУРС");
                goToMenu(user);


                break;
            case "10":
                accountServiseIMP.allMoneyinBank();
                goToMenu(user);

                break;
            case "11":
                System.out.println("Введите id счета который хотите изменить");
                int id1=scanner.nextInt();
                System.out.println(" Введите новый id ");
                int id2= scanner.nextInt();
                accountServiseIMP.changidAccount(id1,id2);
                goToMenu(user);


                break;
            case "12":
                userMenu.register(scanner);
                goToMenu(user);

                goToMenu(user);
                break;
            case "13":
                System.out.println("введите Login клиента: ");
                String loginClient = scanner.nextLine();
                userServiseIMP.findUserForLogin(loginClient);


                goToMenu(user);
                break;
            case "14":
                accountServiseIMP.allUsers();
                goToMenu(user);
                break;
            case "15":
               operationServiceIMP.allOperation();
                goToMenu(user);
                break;
            case "16":

                break;
            default:
                System.out.println("Выберите вариант !");

        }

    }
}
