package exeption;

public class UserExeption {
    public  void passwordExeption() throws MyExeption {
        throw  new MyExeption("Не верный пароль","Не верный пароль Введите пароль еще раз");
}
    public  void loginExeption() throws MyExeption {
        throw  new MyExeption("Такой логин уже существует","Такой логин уже существует Придумайте новый логин");
    }
    public  void goEx() throws MyExeption {
        throw  new MyExeption("","Выберите вариант из меню!");
    }
    public  void loginExeption1() throws MyExeption {
        throw  new MyExeption("Такой логин уже существует","Неверный логин, проверьте ваш логин");
    }
    public  void notfound() throws MyExeption {
        throw  new MyExeption("Такой логин уже существует","Неверный логин, проверьте ваш логин");
    }
}
