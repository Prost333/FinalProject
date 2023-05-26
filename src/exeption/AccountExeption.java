package exeption;

public class AccountExeption extends Exception {
    public  void cashExeption() throws MyExeption {
        throw  new MyExeption("У вас недостаточно средств","У вас недостаточно средств введите иную сумму");
    }
    public  void privetExeption() throws MyExeption {
        throw  new MyExeption("Данный счет не принаделит вам","Данный счет не принаделит вам ");
    }
    public  void foundAccount() throws MyExeption {
        throw  new MyExeption(" ","Счет не найден!!!");
    }
}
