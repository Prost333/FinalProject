package Repository;

import Starts.AlternativStart;
import domain.Account;
import domain.User;
import exeption.MyExeption;
import exeption.UserExeption;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class UserRepository  {
    List<User> users = new ArrayList();

    public  static  String  way= "src/data/User.txt";
    UserExeption userExeption=new UserExeption();
    AlternativStart alternativStart =new AlternativStart();

    public UserRepository() {
    }

    public List<User> CheakPassword (String password)  {
        List<User> userList= users.stream().filter(user -> user.getPassword().equals(password)).collect(Collectors.toList());
        if (userList.isEmpty()){
            return  new ArrayList<>();
        }
        return userList;
    }
    public List<User> CheakLogin (String login)  {
        List<User> userList= users.stream().filter(user -> user.getLogin().equals(login)).collect(Collectors.toList());
        if (userList.isEmpty()){
            return  new ArrayList<>();
        }
        return userList;
    }



        public static List<User> desirialaiz ()  {
            List<User> c =new ArrayList<>();
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(way))){
             c=(List<User>) ois.readObject();
            System.out.println(c);

        }  catch (Throwable e){
//            throw new RuntimeException(e);
        }
            return c;
        }

        public List<User> allUsers1(){
        Object object= desirialaiz();
        List<User>users=new ArrayList<>();
        if ((object instanceof List<?>)){
            users=(List<User>)object;
        }
        return  users;
    }
        public List<User> allUsers(){
        Object object= userListWithoutPrint();
        List<User>users=new ArrayList<>();
        if ((object instanceof List<?>)){
            users=(List<User>)object;
        }
        return  users;
        }
        public User addUser(User user){
        users=allUsers();
        users.add(user);
        serialaiz(users);
        return user;

        }
    public static void serialaiz(List<User> user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(way))) {
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public  static List<User>  userListWithoutPrint ()  {
        List<User> c =new ArrayList<>();
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(way))){
            c=(List<User>) ois.readObject();
        }  catch (Throwable e){
//            throw new RuntimeException(e);
        }
        return c;
    }


    public List<User> update() {
        Object o = userListWithoutPrint();
        if (o instanceof List<?>) {
            users = (List<User>) o;
        }
        return users;
    }
    public User findUserById(int id) {
        List<User> users = userListWithoutPrint();
        Optional<User> user1 =  users.stream().filter(user -> ((Integer) user.getId()).
                equals(id)).findFirst();
        try {
            if (user1.isEmpty()){
                userExeption.notfound();
                alternativStart.goToMenu();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
        }
        return user1.get();
    }
    public User findUserByLogin(String login) {
        List<User> users = userListWithoutPrint();
        Optional<User> user1 =  users.stream().filter(user -> ( user.getLogin()).
                equals(login)).findFirst();
        try {
            if (user1.isEmpty()){
                userExeption.notfound();
                alternativStart.goToMenu();
            }
        } catch (MyExeption e) {
            e.printStackTrace();
        }
        return user1.get();
    }
    public  void deliteUser(User user){
        users=allUsers();
        users.remove(user);
        serialaiz(users);
        update();
    }
    public void saveUser() {
        serialaiz(users);
        update();

    }
    public void saveUser1() {
        serialaiz(userListWithoutPrint());
        update();

    }




    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRepository that = (UserRepository) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }








}
