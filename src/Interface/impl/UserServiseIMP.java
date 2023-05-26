package Interface.impl;
import Interface.UserService;
import Repository.UserRepository;
import Starts.AlternativStart;
import baza.Role;
import domain.User;
import exeption.MyExeption;
import exeption.UserExeption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static Repository.UserRepository.userListWithoutPrint;

public class UserServiseIMP implements UserService {
    Scanner sc = new Scanner(System.in);
    List<User> users = new ArrayList<>();
    UserRepository userRepository = new UserRepository();
    User customer;
    UserExeption userExeption= new UserExeption();
    AlternativStart alternativStart =new AlternativStart();




    @Override
    public User cheakPassword(String login, String password) {
        List<User> users = userListWithoutPrint();
        Optional<User> user1 = users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        try {
            if (user1.isPresent()){
        if (!user1.get().getPassword().equals(password)) {
                userExeption.passwordExeption();
            }
        }else {
            userExeption.loginExeption1();}
        } catch (MyExeption e) {
            e.printStackTrace();
           alternativStart.goToMenu();

        }
        return user1.get();
    }
    public User cheakRolle(Role role) {
        List<User> users = userListWithoutPrint();
        User user1 = users.stream().filter(user -> user.getRole().equals(role)).findFirst().orElseThrow();

        return user1;
    }
    public  User findUserForLogin(String login){
        List<User>userList=userListWithoutPrint();
        Optional<User> user2=userList.stream().filter(user -> user.getLogin().equals(login)).findFirst();
        try {
            if (user2.isEmpty()){
                userExeption.loginExeption();
            }else {
                System.out.println(user2.get());
            }

        }
        catch (MyExeption e) {
            e.printStackTrace();
        }

        return  user2.get();
    }

    @Override
    public User register(String login, String password, String name, String surname) {

        customer = new User(name, surname, login, password, Role.CLIENT);
        int id = 1;
        boolean twoLogin = userListWithoutPrint().stream().anyMatch(user -> user.getLogin().equals(login));
        try {
        if (twoLogin) {
            userExeption.loginExeption();
            }


        if (!users.isEmpty()) {
            id = users.get(users.size() - 1).getId() + 1;
            customer.setId(id);
        }
        customer.setId(userRepository.allUsers().size() + 1);
        userRepository.addUser(customer);
        } catch (MyExeption e) {
            e.printStackTrace();
        }

        return customer;
    }
    public User register1(String login, String password, String name, String surname) {

        customer = new User(name, surname, login, password, Role.ADMIN);
        int id = 1;
        boolean twoLogin = userListWithoutPrint().stream().anyMatch(user -> user.getLogin().equals(login));
        try {
        if (twoLogin) {
                userExeption.loginExeption();
            }

        if (!users.isEmpty()) {
            id = users.get(users.size() - 1).getId() + 1;
            customer.setId(id);
        }
        customer.setId(userRepository.allUsers().size() + 1);
        userRepository.addUser(customer);


        } catch (MyExeption e) {
            e.printStackTrace();
        }
        return customer;
    }


    @Override
    public void changePassword(String login, String OldPassword, String NewPassword, User user) {
        User chenguUser = userRepository.findUserByLogin(login);
        try {
        if (OldPassword.equals(chenguUser.getPassword())) {
            chenguUser.setPassword(NewPassword);
            userRepository.deliteUser(user);
            userRepository.addUser(chenguUser);
            userRepository.saveUser();
            System.out.println("вы успешно изменили пароль");
        }else {
                userExeption.passwordExeption();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
        }


    }

    @Override
    public void changeLogin(String login, String password, String NewLogin,User user) {
        User chenguLoginser = userRepository.findUserByLogin(login);
        try {
        if (password.equals(chenguLoginser.getPassword())) {
            chenguLoginser.setLogin(NewLogin);
            userRepository.deliteUser(user);
            userRepository.addUser(chenguLoginser);
            userRepository.saveUser();
            System.out.println("вы успешно изменили Логин");
        }else {
                userExeption.passwordExeption();
            }
        } catch (MyExeption e) {
           e.printStackTrace();
        }

    }

    public void allUsers() {
        userRepository.allUsers1();
    }
    public  void deliteAccount(int id){
        User user=userRepository.findUserById(id);
        userRepository.deliteUser(user);
        userRepository.saveUser();
        System.out.println("вы успешно удалили свой аккаунт");
    }
    public  void setid (int id, User user){
        user.setId(id);
        userRepository.update();
    }


}
