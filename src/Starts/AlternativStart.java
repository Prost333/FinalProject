package Starts;

import Interface.UserService;
import Interface.impl.CourseIMP;
import Interface.impl.OperationServiceIMP;
import Interface.impl.UserServiseIMP;
import Repository.CourseRepository;
import Repository.UserRepository;
import baza.Role;
import domain.User;
import menu.AdminMenu;
import menu.ClientMenu;
import menu.UserMenu;

import java.util.*;


public class AlternativStart {


    public void goToMenu() {
        Scanner sc = new Scanner(System.in);
        ClientMenu clientMenu = new ClientMenu();
        UserService userService = new UserServiseIMP();
        UserMenu userMenu = new UserMenu(userService);
        List<User> users = new ArrayList<>();
        UserRepository userRepository = new UserRepository();
        User customer;
        AlternativStart bank = new AlternativStart();
        UserServiseIMP userServiseIMP = new UserServiseIMP();
        AdminMenu adminMenu = new AdminMenu();
        OperationServiceIMP operationServiceIMP = new OperationServiceIMP();
        CourseIMP courseIMP = new CourseIMP();
        CourseRepository courseRepository = new CourseRepository();
        courseIMP.courseofDay();
        String choice;
        while (true) {

            System.out.println("\n-------------------");
            System.out.println("BANK    OF     JAVA");
            System.out.println("-------------------\n");
            System.out.println("1. Регистрация");
            System.out.println("2. Логин");
            System.out.println("3. Выход");
            System.out.print("\nВыберите вариант : ");
            choice = sc.nextLine();


            switch (choice) {
                case "1":
                    User user = userMenu.register(sc);

                    System.out.println(user);
                    break;

                case "2":
                    User user1 = userMenu.authenticate(sc);
                    if (user1.getRole().equals(Role.CLIENT)) {
                        clientMenu.goToMenu(user1);
                    } else if (user1.getRole().equals(Role.ADMIN)) {
                        adminMenu.goToMenu(user1);
                    }
                    break;
                case "3":
                    System.out.println("\nПрограмма завершена");
                    System.exit(1);
                    break;

                default:
                    System.out.println("Выберите вариант !");


            }

        }

    }
}

