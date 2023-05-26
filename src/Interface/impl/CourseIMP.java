package Interface.impl;

import Repository.CourseRepository;
import baza.Course1;

import javax.xml.crypto.Data;
import java.awt.image.DataBuffer;
import java.util.Date;
import java.util.Random;

public class CourseIMP {
    CourseRepository courseRepository=new CourseRepository();
    Date date=new Date();
    public Course1 changCourse(double byn,double eur,double usd,double rub){
        Course1 course1=courseRepository.course1();
        course1.setUsd(usd);
        course1.setRub(rub);
        course1.setEur(eur);
        course1.setByn(byn);
        course1.setUsdToRub(rub / usd);
        course1.setUsdToEur(eur/usd);
        course1.setUsdToByn(byn/usd);
        course1.setRubToUsd(usd/rub);
        course1.setRubToByn(byn/rub);
        course1.setRubToEur(eur/rub);
        course1.setEurToUsd(usd/eur);
        course1.setEurToRub(rub/eur);
        course1.setEurToByn(byn/eur);
        course1.setBynToUsd(usd/byn);
        course1.setBynToRub(rub/byn);
        course1.setBynToEur(eur/byn);
        courseRepository.saveAccount();
        return course1;
    }
    public  Course1 course(){
        return courseRepository.course1();
    }

    public void courseofDay(){
        Course1 course1= courseRepository.course1();
        double inflation=(Math.random()*10)*0.001;
        if (date.getHours()>0&&date.getHours()<6){
            course1.setByn(course1.getByn()+inflation);
            course1.setEur(course1.getEur()-inflation);
            course1.setRub(course1.getRub()+inflation);
            course1.setUsd(course1.getUsd()-inflation);
        }
        else  if (date.getHours()>6&&date.getHours()<12){
            course1.setByn(course1.getByn()-inflation);
            course1.setEur(course1.getEur()+inflation);
            course1.setRub(course1.getRub()-inflation);
            course1.setUsd(course1.getUsd()+inflation);

        }
        else  if (date.getHours()>12&&date.getHours()<18){
            course1.setEur(course1.getEur()+inflation);
            course1.setUsd(course1.getUsd()+inflation);

        }
        else  if (date.getHours()>18&&date.getHours()<23){
            course1.setByn(course1.getByn()+inflation);
            course1.setRub(course1.getRub()+inflation);
        }
        else  if (course1.getByn()>5){
            System.out.println("Уважаемые клиенты произошла деноминация");
            course1.setByn(2.819);
            course1.setEur(0.896);
            course1.setRub(78.1);
            course1.setUsd(1);
        }
        courseRepository.saveAccount();
    }
}
