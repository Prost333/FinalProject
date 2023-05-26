package Repository;

import domain.Operation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperationRepositoty {
    public static List<Operation> operations = new ArrayList<>();
    public static String fileOperation = "src/data/Operation.txt";


    @Override
    public String toString() {
        return "OperationRepository{" +
                "Operation=" + operations+
                '}';
    }


    public static void serialaiz(List<Operation> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileOperation))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Operation> desirialaiz() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileOperation))) {
            operations = (List<Operation>) ois.readObject();
        } catch (Throwable e) {
//            throw new ;
        }
        return operations;
    }
    public  List<Operation> operationWitOutPrint() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileOperation))) {
            operations = (List<Operation>) ois.readObject();

        } catch (Throwable e) {
//            throw new ;
        }
        return operations;
    }
    public List<Operation> update() {
        Object o = operationWitOutPrint();
        if (o instanceof List<?>) {
            operations = (List<Operation>) o;
        }
        return operations;
    }

    public void saveAccount() {
        serialaiz(operations);
        update();

    }
    public Operation addOperation(Operation operation) {
        operations = desirialaiz();
        operations.add(operation);
        serialaiz(operations);
        return operation;
    }
    public List<Operation> allOperation() {
        Object object = desirialaiz();
        List<Operation> operations1 = new ArrayList<>();
        if ((object instanceof List<?>)) {
            operations1 = (List<Operation>) object;
        }
        System.out.println(operations1);
        return operations1;
    }
}
