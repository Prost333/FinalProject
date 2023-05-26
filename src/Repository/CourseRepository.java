package Repository;

import baza.Course1;
import domain.Account;
import domain.Operation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    List<Course1>course1List=new ArrayList<>();
    Course1 course1=new Course1();
   static String file = "src/data/Course.txt";

    public  void serialaiz(Course1 course1s) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(course1s);
        } catch (Throwable throwable) {
//            throw new RuntimeException(e);
        }
    }

    public  Course1 desirialaiz() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            course1 = (Course1) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("объект не найден");
        } catch (IOException e) {
//            System.out.println("херня не найден");
        } catch (ClassNotFoundException e) {
            System.out.println("класс не найден");
        }
        return  course1;
    }
    public Course1 course1() {
        Object object = desirialaiz();
        Course1 accounts1 = new Course1();
        if ((object instanceof Course1)) {
            accounts1 = (Course1) object;
        }
        return accounts1;
    }
    public Course1 update() {
        Object o = course1();
        if (o instanceof List<?>) {
           course1 = (Course1) o;
        }
        return course1;
    }

    public void saveAccount() {
        serialaiz(course1);
        update();

    }



}
