package domain;

import java.io.Serializable;

public class Operation implements Serializable {
    private  long id;
    private  long clientIdTo;
    private  String clientToName;
    private  String clientToSurname;
    private  int clientToAccount;
    private  String currency;
    private  double value;
    private  double comission;
    private  int sendid;
    private  int sendIDAccount;
    public Operation(long id, long clientIdTo, String clientToName, String clientToSurname, int clientToAccount) {
        this.id = id;
        this.clientIdTo = clientIdTo;
        this.clientToName = clientToName;
        this.clientToSurname = clientToSurname;
        this.clientToAccount = clientToAccount;
    }

    public int getSendid() {
        return sendid;
    }

    public void setSendid(int sendid) {
        this.sendid = sendid;
    }

    public int getSendIDAccount() {
        return sendIDAccount;
    }

    public void setSendIDAccount(int sendIDAccount) {
        this.sendIDAccount = sendIDAccount;
    }

    public Operation() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getComission() {
        return comission;
    }

    public void setComission(double comission) {
        this.comission = comission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientIdTo() {
        return clientIdTo;
    }

    public void setClientIdTo(long clientIdTo) {
        this.clientIdTo = clientIdTo;
    }

    public String getClientToName() {
        return clientToName;
    }

    public void setClientToName(String clientToName) {
        this.clientToName = clientToName;
    }

    public String getClientToSurname() {
        return clientToSurname;
    }

    public void setClientToSurname(String clientToSurname) {
        this.clientToSurname = clientToSurname;
    }

    public int getClientToAccount() {
        return clientToAccount;
    }

    public void setClientToAccount(int clientToAccount) {
        this.clientToAccount = clientToAccount;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "Номер операции=" + id +
                ", id отправителя=" + clientIdTo +
                ", Имя отправителя='" + clientToName + '\'' +
                ", Фамилия отправителя='" + clientToSurname + '\'' +
                ", Номер счета отправителя=" + clientToAccount +
                ", Валюта='" + currency + '\'' +
                ", Сумма=" + value +
                ", Комиссия=" + comission +
                ", Номер счета получателя= "+sendIDAccount+
                '}';
    }
}
