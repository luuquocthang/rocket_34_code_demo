package org.example;

import org.example.dao.StudentDao;

import java.sql.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
//        Date dob = new Date(1994, 8, 1);
        Date dob1 = Date.valueOf("1994-09-01");
        Student s1 = new Student(1, "luu thang", dob1, "thangluu10@yahoo.com.vn", 9.0, "Dai Mo");
        Student s2 = new Student(1, "luu thang", dob1, "thangluu11@yahoo.com.vn", 9.0, "Dai Mo");
        Student s3 = new Student(1, "luu thang", dob1, "thangluu8@yahoo.com.vn", 9.0, "Dai Mo");
        ArrayList<Student> sts = new ArrayList<>();
        sts.add(s1);
        sts.add(s2);
        sts.add(s3);
        studentDao.testTransaction(sts);
//        String insertResult = studentDao.insert(s1);
//        System.out.println(insertResult);
        ArrayList<Student> students = studentDao.selectAll();
        for (Student s: students) {
            System.out.println(s);
        }

        String resultCall = studentDao.updateAddressByStored("Duong Dai Mo, Phuong Dai Mo, Nam Tu Liem, Ha Noi", 1);
        System.out.println(resultCall);
    }
}