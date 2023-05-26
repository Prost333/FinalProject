package Interface.impl;

import Interface.OperatorService;
import Repository.OperationRepositoty;
import domain.Account;
import domain.Operation;
import domain.User;

import java.util.List;
import java.util.Scanner;

public class OperationServiceIMP implements OperatorService {
    Scanner sc = new Scanner(System.in);

    OperationRepositoty operationRepositoty=new OperationRepositoty();
    AccountServiseIMP accountServiseIMP= new AccountServiseIMP();
    @Override
    public Operation creatOperation(User user1, Account account, double money, Account account2) {
        Operation operation=new Operation();
        operation.setValue(money);
        operation.setClientIdTo(user1.getId());
        operation.setClientToSurname(user1.getSurname());
        operation.setCurrency(account.getCurrency());
        operation.setClientToName(user1.getName());
        operation.setClientToAccount(account.getId());
        operation.setId(operationRepositoty.operationWitOutPrint().size()+1);
        operation.setComission(accountServiseIMP.comissionBANKtoOperation(account.getId(),money));
        operation.setSendIDAccount(account2.getId());
        operationRepositoty.addOperation(operation);

        return operation;
    }

    @Override
    public List<Operation> getOperationbyClient(int clientid) {
        List<Operation>operationList=operationRepositoty.desirialaiz();
        List<Operation>operationsClient= operationList.stream().filter(operation1 -> operation1
                .getClientIdTo()==clientid).toList();
        if (!operationsClient.isEmpty()){
        System.out.println(operationsClient);}
        else {
            System.out.println("Операции отстутствуют");
        }
      return operationsClient;
    }

    @Override
    public List<Operation> getOperationbyAccountClient(int clientid, int idAccount) {
        return null;
    }

    @Override
    public List<Operation> getOperationbyCurrency(String currency) {
        return null;
    }


    public void allOperation() {
        operationRepositoty.allOperation();
    }
}
