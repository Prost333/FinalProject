package Interface;

import domain.Account;

import javax.xml.crypto.Data;
import java.util.List;

public interface AccountService {
    Account creatAccount (int userId,String accountNumer, String currency);
    Account passMoney(int accountId, double money);
    List<Account> getAccountByClient(int userId);

}
