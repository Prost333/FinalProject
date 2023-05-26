package baza;

public enum Role {
    ADMIN("Администратор"),
    CLIENT("Клиент");

    String k;
    Role(String k){
        this.k=k;
    }
}
