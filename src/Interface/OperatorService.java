package Interface;

import domain.Account;
import domain.Operation;
import domain.User;

import java.util.List;

public interface OperatorService {
    Operation creatOperation(User user, Account account,double money, Account account2);
    List<Operation> getOperationbyClient (int clientid);
    List<Operation> getOperationbyAccountClient (int clientid, int idAccount);
    List<Operation> getOperationbyCurrency (String currency);


}
