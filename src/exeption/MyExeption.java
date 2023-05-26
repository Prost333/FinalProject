package exeption;

public class MyExeption extends  Exception{
    private String Code;

    public MyExeption(String message, String code) {
        super(message);
        Code = code;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String toString() {
        return "ОШИБКА!!" +Code ;
    }
}

