package vn.vti.test;

import vn.vti.entities.Employee;
import vn.vti.entities.Person;
import vn.vti.entities.Student;
import vn.vti.interfaces.IPerson;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println("Test:" + employee.test);
        System.out.println("Id:" + employee.getId());
        Employee employee1 = new Employee(1, "luu quoc thang");
        employee1.showInfo();
//        Long date = 778352400000l;

        Date date = new Date(778352400000l);
        Date date_util_1 = new Date(1994, 8, 1);
        java.sql.Date date1 = java.sql.Date.valueOf("1994-09-01");
        System.out.println(date1);
        Employee employee2 = new Employee(2, "luu thang", date, "test", 1, "HN");
        employee2.showInfo();
        employee2.setSalary(500);
        Employee employee3 = new Employee(1, "luu quoc thang", 18, 2, "luu thang", date, "test", 1, "HN", false);
        employee3.setCardNumber(12345678);
        employee3.incrementSalary(1000);
        employee3.showInfo();
        employee3.showCarNumber();
        System.out.println(employee3.CURRENT_YEAR);
        System.out.println(IPerson.CURRENT_YEAR);
        System.out.println(employee1.getSalary());
        employee1.setSalary(100);
        employee2.incrementSalary(200);
        employee3.incrementSalary(300);
        employee3.showNameSalary();
        System.out.println("result" + employee1.getSalary());
        String a1 = "luu quoc thang";
        String a2 = "luu quoc thang";
        if (a1 == a2) {
            System.out.println("a1 = a2");
        } else  {
            System.out.println("a1 != a2");
        }

        String b1 = new String("luu quoc thang"); //345
        String b2 = new String("luu quoc thang"); //456
        if (b1 == b2) {
            System.out.println("b1 = b2");
        } else  {
            System.out.println("b1 != b2");
        }

        // Polymorphism
        String[] name = {"D12CN4", "B2", "A17"};
        Person p0 = new Person(9, "luu quoc thang0", 18, 123456);
        Person p1 = new Student(10, "luu quoc thang1", 18, 123456, 5, name);
        Person p2 = new Employee(11, "luu thang2");
        System.out.println("============");
        p0.showInfo();
        System.out.println("============");
        p1.showInfo();
        System.out.println("============");
        p2.showInfo();
        System.out.println("============");
        Student s1 = new Student(12, "luu thang 3", 18, 12345, 5, name);
        System.out.println(s1.sum(1f,2));
        System.out.println(s1.sum(1,2, 3, 4));
        System.out.println(s1.sum(1,2, 5));

    }
}