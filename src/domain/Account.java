package domain;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private  int id;
    private  String accountNumer;
    private String currency;
    private  Double value;
    private  int userId;

    public Account() {
    }

    public Account(int id, String accountNumer, String currency, Double value, int userId) {
        this.id = id;
        this.accountNumer = accountNumer;
        this.currency = currency;
        this.value = value;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumer() {
        return accountNumer;
    }

    public void setAccountNumer(String accountNumer) {
        this.accountNumer = accountNumer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumer='" + accountNumer + '\'' +
                ", currency='" + currency + '\'' +
                ", value=" + value +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && userId == account.userId && Objects.equals(accountNumer, account.accountNumer) && Objects.equals(currency, account.currency) && Objects.equals(value, account.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumer, currency, value, userId);
    }
}
