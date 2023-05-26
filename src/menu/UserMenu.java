package menu;

import Interface.UserService;
import Repository.UserRepository;
import Starts.AlternativStart;
import domain.User;
import exeption.MyExeption;
import exeption.UserExeption;

import java.util.Scanner;

public class UserMenu  {

    private  UserService userServiceIMP;
    UserExeption userExeption = new UserExeption();
    AlternativStart alternativStart =new AlternativStart();

    public UserMenu() {
    }

    public UserMenu(UserService userService){this.userServiceIMP= userService;

    }

    public UserService getUserServiceIMP() {
        return userServiceIMP;
    }

    public void setUserServiceIMP(UserService userServiceIMP) {
        this.userServiceIMP = userServiceIMP;
    }

    public  User authenticate (Scanner scanner){
            System.out.println("Введите логин: ");
            String login = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
            return userServiceIMP.cheakPassword(login, password);
    }

    public User register (Scanner scanner){
        System.out.println("Введите логин: ");
        String login =scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        return userServiceIMP.register(login, password,name,surname);

    }

}
